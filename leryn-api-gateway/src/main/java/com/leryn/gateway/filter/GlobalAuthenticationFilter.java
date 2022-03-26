package com.leryn.gateway.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.annotation.Resource;

import com.leryn.common.vo.Result;
import com.leryn.gateway.config.IgnoredUrlConfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Slf4j
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
      if (StringUtils.hasText(accessToken)) {
        ResponseEntity<Result> response = validateAccessToken(accessToken);
        int statusCode = response.getStatusCodeValue();
        if (statusCode >= HttpStatus.OK.value() && statusCode < HttpStatus.MULTIPLE_CHOICES.value()) {
          Result result = response.getBody();
          Assert.notNull(result, () -> "Result are unexpected.");
          ServerWebExchange newExchange = rewriteCredential(exchange, result);
          return chain.filter(newExchange);
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
      if (!CollectionUtils.isEmpty(header)) {
        accessToken = params.get(0);
      }
    }
    return accessToken;
  }

  private ResponseEntity<Result> validateAccessToken(String accessToken) {
    Map<String, String> params = new HashMap<>();
    params.put("v", accessToken);
    ResponseEntity<Result> response = restTemplate.getForEntity(authServer + "/access?v={v}", Result.class, params);
    return response;
  }

  private ServerWebExchange rewriteCredential(ServerWebExchange exchange, Result result) {
    Map<String, String> map = (Map<String, String>) result.getData();
    return exchange.mutate().request(
      request -> {
        request.headers(new Consumer<HttpHeaders>() {
          @Override
          public void accept(HttpHeaders headers) {
            headers.addIfAbsent("X-Credential-Id", map.get("username"));
          }
        });
      }
    ).build();
  }

}
