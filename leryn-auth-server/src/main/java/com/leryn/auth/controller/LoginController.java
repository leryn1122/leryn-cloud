package com.leryn.auth.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leryn.auth.components.PlainTextPasswordEncoder;
import com.leryn.auth.constant.SecurityConstants;
import com.leryn.auth.exception.UsernameNotFoundException;
import com.leryn.auth.service.UserService;
import com.leryn.auth.util.JwtUtils;
import com.leryn.auth.vo.LoginFormVo;
import com.leryn.common.vo.RestfulResponse;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
@RequestMapping("/v1")
public class LoginController {

  @Resource
  private UserService userService;

  @Resource
  private RedisTemplate<String, Object> redisTemplate;

  @PostMapping("/login.do")
  public RestfulResponse login(@RequestBody @Validated LoginFormVo loginFormVo) throws UsernameNotFoundException {
    String username = loginFormVo.getUsername();
    String password = loginFormVo.getPassword();

    if (!userService.verifyUserByCredential(username, password)) {
      return RestfulResponse.onError(SecurityConstants.PASSWORD_INVALID);
    }

    String token = JwtUtils.sign(username, password);
    redisTemplate.opsForValue().set(SecurityConstants.TOKEN_PREFIX + token, token, JwtUtils.EXPIRE_TIME * 2, TimeUnit.MILLISECONDS);

    Map<String, Object> map = new HashMap<>();
    map.put(
      "token", token
//      "avatar", "https://leryn-website.oss-cn-shanghai.aliyuncs.com/img/mercy_and_moira.jpg"
    );
    return RestfulResponse.onSuccess("Login success!!", map);
  }

  @GetMapping("/logout.do")
  public RestfulResponse logout(HttpServletRequest request, HttpServletResponse response) {
    String token = request.getHeader(SecurityConstants.X_ACCESS_TOKEN);
    if (StringUtils.hasLength(token)) {
      redisTemplate.delete(SecurityConstants.TOKEN_PREFIX + token);
      return RestfulResponse.onSuccess("Logout success!!");
    }
    return RestfulResponse.onSuccess("You haven't login yet.");
  }

  @GetMapping("/getPermCode.do")
  public RestfulResponse getPermissionCode(HttpServletRequest request) {
    return RestfulResponse.onSuccess(HttpServletResponse.SC_UNAUTHORIZED, SecurityConstants.UNAUTHORIZED);
  }
}
