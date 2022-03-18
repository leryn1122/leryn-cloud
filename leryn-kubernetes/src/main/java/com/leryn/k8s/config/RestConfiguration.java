package com.leryn.k8s.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Configuration
public class RestConfiguration {

  @Component
  public static class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution)
      throws IOException {
      ClientHttpResponse response = execution.execute(request, bytes);
      HttpHeaders headers = response.getHeaders();
      headers.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList(MimeTypeUtils.APPLICATION_JSON_VALUE));
      return response;
    }
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    restTemplate.setInterceptors(Collections.singletonList(new CustomClientHttpRequestInterceptor()));
    return restTemplate;
  }

}
