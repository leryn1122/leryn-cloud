package com.leryn.gateway.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.leryn.common.vo.RestfulResponse;
import com.leryn.gateway.config.IgnoredUrlConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Component
public class GlobalAuthenticationFilter implements GlobalFilter, Ordered {

  @Resource
  private IgnoredUrlConfiguration ignoredUrlConfiguration;

  @Resource
  private RestTemplate restTemplate;

  @Value("${application.gateway.auth-server}")
  private String authServer;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    String path = request.getPath().toString();
    if (!determineIgnoredUrl(path)) {
      String accessToken = obtainAccessToken(request);
      System.out.println("返回认证中心: " + accessToken);
      if (StringUtils.hasText(accessToken)) {
        Map<String, String> params = new HashMap<>();
        params.put("v", accessToken);
        ResponseEntity<RestfulResponse> response = restTemplate.getForEntity(authServer + "/access?v={v}", RestfulResponse.class, params);
        int statusCode = response.getStatusCodeValue();
        if (statusCode >= HttpStatus.OK.value() && statusCode <= HttpStatus.MULTIPLE_CHOICES.value()) {
          return chain.filter(exchange);
        } else {
          return Mono.empty();
        }
      }
    }
    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return -1;
  }

  private boolean determineIgnoredUrl(String path) {
    return CollectionUtils.contains(
      ignoredUrlConfiguration.getIgnoredUrl().iterator(), path);
  }

  private String obtainAccessToken(ServerHttpRequest request) {
    String accessToken = null;
    List<String> header = request.getHeaders().get("X-Access-Token");
    if (!CollectionUtils.isEmpty(header)) {
      accessToken = header.get(0);
    } else {
      List<String> params = request.getQueryParams().get("access_token");
      if (CollectionUtils.isEmpty(header)) {
        accessToken = params.get(0);
      }
    }
    return accessToken;
  }

}
