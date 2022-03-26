package com.leryn.auth.controller;

import com.leryn.common.vo.Result;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
@RequestMapping("/v1")
public class HealthController {

  @GetMapping("/health.do")
  public Result healthCheck() {
    return Result.onSuccess("Health check passed!!");
  }

}
