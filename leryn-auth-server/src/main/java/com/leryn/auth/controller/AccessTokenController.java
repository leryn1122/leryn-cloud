package com.leryn.auth.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import com.leryn.auth.constant.SecurityConstants;
import com.leryn.auth.util.JwtUtils;
import com.leryn.common.vo.Result;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
@RequestMapping
public class AccessTokenController {

  @Resource
  private RedisTemplate<Object, Object> redisTemplate;

  @Resource
  private AuthorizationController authorizationController;

  @GetMapping("/access")
  public Result validateAccessToken(@NotNull @RequestParam("v") String token,
                                    HttpServletResponse response) {
    Object value = redisTemplate.opsForValue().get(SecurityConstants.TOKEN_PREFIX + token);
    if (null != value) {
      String username = JwtUtils.getUsername(token);
      Entry<String, String> entry = new SimpleEntry<>("X-Credential-ID", username);
      return Result.onSuccess("Accessed!!", entry);
    }
    return authorizationController.forbidden(response);
  }

}
