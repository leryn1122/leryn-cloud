package com.leryn.auth.controller;

import javax.servlet.http.HttpServletResponse;

import com.leryn.auth.constant.SecurityConstants;
import com.leryn.common.vo.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
@RequestMapping("/v1")
public class AuthorizationController {

  @RequestMapping(value = "/401", method = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT
  })
  public Result unauthorized(HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    return Result.onError(HttpServletResponse.SC_UNAUTHORIZED, SecurityConstants.UNAUTHORIZED);
  }

  @RequestMapping(value = "/403", method = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT
  })
  public Result forbidden(HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    return Result.onError(HttpServletResponse.SC_FORBIDDEN, SecurityConstants.FORBIDDEN);
  }
}
