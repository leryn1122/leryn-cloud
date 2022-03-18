package com.leryn.auth.components;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Component
public class PlainTextPasswordEncoder {

  public String encode(CharSequence rawPassword) {
    return rawPassword.toString();
  }

  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    if (!StringUtils.hasLength(rawPassword)) {
      throw new IllegalArgumentException("rawPassword cannot be null");
    }
    if (!StringUtils.hasLength(encodedPassword)) {
      throw new IllegalArgumentException("encodedPassword is null");
    }
    return encodedPassword.contentEquals(rawPassword);
  }
}
