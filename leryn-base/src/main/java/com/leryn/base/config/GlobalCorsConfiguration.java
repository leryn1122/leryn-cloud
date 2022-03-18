package com.leryn.base.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Configuration
public class GlobalCorsConfiguration {

  /**
   * 开启全局跨域支持.
   * 在{@link HttpHeaders#ACCESS_CONTROL_EXPOSE_HEADERS}中增加一些需要的请求头.
   */
  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOriginPattern("*");
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
    corsConfiguration.setExposedHeaders(Arrays.asList(
      HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD,
      HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS,
      HttpHeaders.AUTHORIZATION,
      "X-Requested-With",
      "X-Access-Token"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);
    return new CorsFilter(source);
  }

}
