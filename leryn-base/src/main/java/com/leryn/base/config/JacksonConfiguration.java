package com.leryn.base.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Configuration
public class JacksonConfiguration {

  @Bean
  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
    ObjectMapper objectMapper = jackson2ObjectMapperBuilder.createXmlMapper(false).build();
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    return objectMapper;
  }

}
