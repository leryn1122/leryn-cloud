package com.leryn.auth.constant;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public abstract class SecurityConstants {

  // Prompt.
  //==========================================================================//

  public static final String INVALID_TOKEN = "Token is null!";

  public static final String UNAUTHORIZED = "Unauthorized.";

  public static final String FORBIDDEN = "Forbidden.";

  public static final String USER_NOT_FOUNDED = "User not founded.";

  public static final String USER_NOT_EXIST = "User not exist.";

  public static final String PASSWORD_INVALID = "Password incorrect.";

  // Header.
  //==========================================================================//

  public static final String TOKEN_HEADER = "token";

  public static final String X_ACCESS_TOKEN = "X-Access-Token";

  public static final String TOKEN_PREFIX = "auth:token:";

  private SecurityConstants() {}

}
