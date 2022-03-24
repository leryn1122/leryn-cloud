package com.leryn.gateway.util;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

  private static ApplicationContext applicationContext = null;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContextHolder.applicationContext = applicationContext;
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  @Override
  public void destroy() {
    applicationContext = null;
  }

  //==========================================================================//
  // Bean.
  //==========================================================================//

  public static Object getBean(String name) {
    return getApplicationContext().getBean(name);
  }

  public static <T> T getBean(Class<T> clazz) {
    return getApplicationContext().getBean(clazz);
  }

  public static <T> T getBean(String name, Class<T> clazz) {
    return getApplicationContext().getBean(name, clazz);
  }

  //==========================================================================//
  // Profiles.
  //==========================================================================//

  public static String[] getProfiles() {
    return getApplicationContext().getEnvironment().getActiveProfiles();
  }

  public static boolean isProfileActive(String profile) {
    String[] profiles = getProfiles();
    return Arrays.asList(profiles).contains(profile);
  }

}
