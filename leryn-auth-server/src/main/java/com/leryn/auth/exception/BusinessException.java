package com.leryn.auth.exception;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public class BusinessException extends RuntimeException {

  public BusinessException() {
  }

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }

  public BusinessException(Throwable cause) {
    super(cause);
  }
}
