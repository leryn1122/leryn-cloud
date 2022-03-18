package com.leryn.auth.controller;

import javax.servlet.http.HttpServletResponse;

import com.leryn.auth.constant.SecurityConstants;
import com.leryn.common.vo.RestfulResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
public class AuthorizationController {

  @RequestMapping(value = "/401", method = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT
  })
  public RestfulResponse unauthorized(HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    return RestfulResponse.onError(HttpServletResponse.SC_UNAUTHORIZED, SecurityConstants.UNAUTHORIZED);
  }

  @RequestMapping(value = "/403", method = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT
  })
  public RestfulResponse forbidden(HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    return RestfulResponse.onError(HttpServletResponse.SC_FORBIDDEN, SecurityConstants.FORBIDDEN);
  }
}
