package com.leryn.auth.controller;

import javax.annotation.Resource;

import com.leryn.auth.service.RegisterService;
import com.leryn.auth.vo.RegisterFormVo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
@RequestMapping("/v1")
public class RegisterController {

  @Resource
  private RegisterService registerService;

  @PostMapping("/register.do")
  public String register(@RequestBody @Validated RegisterFormVo registerFormVo) {
    registerService.registerNewUser(registerFormVo);
    return "Register success.";
  }
}
