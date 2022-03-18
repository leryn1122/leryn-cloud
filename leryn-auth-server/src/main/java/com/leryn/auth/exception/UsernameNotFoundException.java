package com.leryn.auth.exception;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public class UsernameNotFoundException extends Exception {

  public UsernameNotFoundException() {
  }

  public UsernameNotFoundException(String message) {
    super(message);
  }

  public UsernameNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public UsernameNotFoundException(Throwable cause) {
    super(cause);
  }
}
