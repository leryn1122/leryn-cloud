package com.leryn.gateway.config;

import com.google.common.base.Joiner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Configuration
public class GlobalCorsConfiguration {

  private static final String ACCESS_CONTROL_ALLOW_METHODS = Joiner.on(',').join(
    HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.OPTIONS);

  private static final String ACCESS_CONTROL_ALLOW_HEADERS = Joiner.on(',').join(
    HttpHeaders.AUTHORIZATION,
    HttpHeaders.CONTENT_TYPE,
    "X-Requested-With",
    "X-Access-Token");

  private static final String ACCESS_CONTROL_EXPOSE_HEADERS = Joiner.on(',').join(
    HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD,
    HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS,
    HttpHeaders.AUTHORIZATION,
    "X-Requested-With",
    "X-Access-Token");


  @Bean
  public WebFilter corsFilter() {
    return (ServerWebExchange exchange, WebFilterChain chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      if (CorsUtils.isCorsRequest(request)) {
        ServerHttpResponse response = exchange.getResponse();
        HttpHeaders headers = response.getHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, exchange.getRequest().getHeaders().getOrigin());
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, ACCESS_CONTROL_ALLOW_METHODS);
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, ACCESS_CONTROL_ALLOW_HEADERS);
        headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, ACCESS_CONTROL_EXPOSE_HEADERS);
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "18000");
        if (HttpMethod.OPTIONS == request.getMethod()) {
          response.setStatusCode(HttpStatus.OK);
          return Mono.empty();
        }
      }
      return chain.filter(exchange);
    };
  }
}
