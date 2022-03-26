package com.leryn.gateway.filter;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Optional;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Slf4j
@Component
public class GlobalLoggerFilter implements GlobalFilter, Ordered {

  @SuppressWarnings({"ConstantConditions", "OptionalGetWithoutIsPresent"})
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    Set<URI> originalUris = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
    URI originalUri = originalUris.stream().findFirst().get();
    URI targetUri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
    HttpMethod method = request.getMethod();
    InetSocketAddress remoteAddress = request.getRemoteAddress();
    return chain.filter(exchange.mutate().build()).then(Mono.fromRunnable(() -> {
      ServerHttpResponse response = exchange.getResponse();
      HttpStatus statusCode = Optional.ofNullable(response.getStatusCode()).orElse(HttpStatus.INTERNAL_SERVER_ERROR);
      log.info("{} [ {} ] -> [ {} ] from \"{}\", code: {}",
        method, originalUri, targetUri, remoteAddress, statusCode);
    }));
  }

  @Override
  public int getOrder() {
    return Integer.MAX_VALUE;
  }
}
