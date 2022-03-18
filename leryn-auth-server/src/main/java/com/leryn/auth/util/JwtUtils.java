package com.leryn.auth.util;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.leryn.auth.constant.SecurityConstants;
import com.leryn.auth.exception.BusinessException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.StringUtils;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public class JwtUtils {

  public static void main(String[] args) {
    String username = "Leryn";
    String token = sign(username, "123456");
    System.out.println("Token is : " + token);
    System.out.println("Verification is : " + verify(token, username, "123456"));
  }

  private static final String USERNAME = "username";

  /** JWT过期时间: 30分钟 */
  public static final long EXPIRE_TIME = 30 * 60 * 1000L;

  /**
   * 验证Token
   */
  public static boolean verify(String token, String username, String secret) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier jwtVerifier = JWT.require(algorithm)
        .withClaim(USERNAME, username).build();
      DecodedJWT decodedJWT = jwtVerifier.verify(token);
      return true;
    } catch (JWTVerificationException | IllegalArgumentException e) {
      return false;
    }
  }

  /**
   * 从Token获取用户名
   */
  public static String getUsername(String token) {
    try {
      DecodedJWT decodedJWT = JWT.decode(token);
      return decodedJWT.getClaim(USERNAME).asString();
    } catch (JWTDecodeException e) {
      return null;
    }
  }

  /**
   * 颁发Token
   */
  public static String sign(String username, String secret) {
    Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.create().withClaim(USERNAME, username)
      .withExpiresAt(date).sign(algorithm);
  }

  /**
   * 从请求中获取Token
   */
  public static String getUserNameByToken(HttpServletRequest request) throws BusinessException {
    String accessToken = request.getHeader(SecurityConstants.X_ACCESS_TOKEN);
    String username = getUsername(accessToken);
    if (!StringUtils.hasText(username)) {
      throw new BusinessException(SecurityConstants.USER_NOT_FOUNDED);
    }
    return username;
  }

}
