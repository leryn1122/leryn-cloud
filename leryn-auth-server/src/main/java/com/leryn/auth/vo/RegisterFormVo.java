package com.leryn.auth.vo;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Data
@NoArgsConstructor
public class RegisterFormVo {
  @NotEmpty(message = "Username must not be empty.")
  private String username;
  @NotEmpty(message = "Password must not be empty.")
  private String password;
}
