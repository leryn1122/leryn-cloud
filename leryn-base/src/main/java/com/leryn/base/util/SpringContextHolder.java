package com.leryn.base.util;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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

  //==========================================================================//
  // HTTP.
  //==========================================================================//

  public static HttpServletRequest getHttpServletRequest() {
    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  }

  public static HttpServletResponse getHttpServletResponse() {
    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
  }

  public static String getDomain() {
    HttpServletRequest request = getHttpServletRequest();
    StringBuffer url = request.getRequestURL();
    return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
  }

  public static String getOrigin() {
    HttpServletRequest request = getHttpServletRequest();
    return request.getHeader("Origin");
  }

}
