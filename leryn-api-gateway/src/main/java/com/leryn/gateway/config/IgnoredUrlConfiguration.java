package com.leryn.gateway.config;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;

import com.leryn.gateway.data.Tables;

import org.jooq.DSLContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Configuration
public class IgnoredUrlConfiguration implements InitializingBean {

  @Resource
  private DSLContext dsl;

  private List<String> ignoredUrl;

  @Override
  public void afterPropertiesSet() throws Exception {
    String[] strings = dsl.select(Tables.IGNORED_URL.URL)
      .from(Tables.IGNORED_URL)
      .fetchArray(Tables.IGNORED_URL.URL, String.class);
    ignoredUrl = Arrays.asList(strings);
  }

  public List<String> getIgnoredUrl() {
    return ignoredUrl;
  }
}
