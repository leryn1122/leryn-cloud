package com.leryn.base.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.leryn.base.util.SpringContextHolder;
import com.leryn.base.vo.ApiMethodVo;
import com.leryn.common.vo.RestfulResponse;

import lombok.SneakyThrows;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
public class DebugController {

  /**
   * 列出所有API接口的信息
   * 注意: {@link RequestMapping} 必须给出所有的{@link RequestMethod}, 否则无法检测到HTTP的方法.
   */
  @SneakyThrows
  @GetMapping("/api")
  public RestfulResponse listAllApi(HttpServletRequest httpServletRequest) {
    ServletContext servletContext = httpServletRequest.getSession().getServletContext();
    if (null == servletContext) {
      return null;
    }
    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    if (null == webApplicationContext) {
      return null;
    }

    List<ApiMethodVo> apiMethodItems = new ArrayList<>();
    Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(
      webApplicationContext, HandlerMapping.class, true, false);

    for (HandlerMapping handlerMapping : allRequestMappings.values()) {
      if (handlerMapping instanceof RequestMappingHandlerMapping) {
        RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
        Map<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodMap =
          requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry :
          requestMappingInfoHandlerMethodMap.entrySet()) {
          RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
          HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();

          RequestMethodsRequestCondition requestMethodsRequestCondition = requestMappingInfo.getMethodsCondition();
          for (RequestMethod requestMethod : requestMethodsRequestCondition.getMethods()) {
            String requestType = requestMethod.name();

            PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();

            Set<String> requestUrls = patternsCondition.getPatterns();
            if (CollectionUtils.isEmpty(requestUrls)) {
              break;
            }

            for (String requestUrl : requestUrls) {
              String controllerName = mappingInfoValue.getBeanType().toString();
              String requestMethodName = mappingInfoValue.getMethod().getName();
              Class<?>[] methodParamTypes = mappingInfoValue.getMethod().getParameterTypes();
              ApiMethodVo apiMethodVo = ApiMethodVo.builder()
                .requestUrl(requestUrl)
                .requestType(requestType)
                .controllerName(controllerName)
                .methodName(requestMethodName)
                .methodParmaTypes(methodParamTypes)
                .build();
              apiMethodItems.add(apiMethodVo);
            }
          }
        }
      }
    }
    return RestfulResponse.onSuccess(apiMethodItems);
  }

  /**
   * 获取所有的Bean
   */
  @SneakyThrows
  @GetMapping("/bean")
  public RestfulResponse listAllBeans() {
    ConfigurableApplicationContext applicationContext =
      (ConfigurableApplicationContext) SpringContextHolder.getApplicationContext();
    List<String> beanNames = Arrays.asList(applicationContext.getBeanDefinitionNames());
    return RestfulResponse.onSuccess(beanNames);
  }

}
