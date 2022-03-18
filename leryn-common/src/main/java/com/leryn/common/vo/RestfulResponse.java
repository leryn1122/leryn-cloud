package com.leryn.common.vo;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public class RestfulResponse {

  // Static Fields.

  private static final int SUCCESS_CODE = 0;

  private static final int ERROR_CODE = - 1;

  // Static Methods.

  public static RestfulResponse onSuccess(int code, String message, Object data) {
    return new RestfulResponse(code, message, data);
  }

  public static RestfulResponse onSuccess(int code, String message) {
    return onSuccess(code, message, null);
  }

  public static RestfulResponse onSuccess(String message) {
    return onSuccess(SUCCESS_CODE, message, null);
  }

  public static RestfulResponse onSuccess(String message, Object data) {
    return onSuccess(SUCCESS_CODE, message, data);
  }

  public static RestfulResponse onSuccess(Object data) {
    return onSuccess(SUCCESS_CODE, "", data);
  }

  public static RestfulResponse onError(int code, String message, Object data) {
    return new RestfulResponse(code, message, data);
  }

  public static RestfulResponse onError(int code, String message) {
    return onError(code, message, null);
  }

  public static RestfulResponse onError(String message) {
    return onError(ERROR_CODE, message, null);
  }

  public static RestfulResponse onError(String message, Object data) {
    return onError(ERROR_CODE, message, data);
  }

  // Fields.

  /** Http code. */
  private int code;

  /** Http message. */
  private String message;

  private Object data;

  // Constructors.

  private RestfulResponse() {
    this(0, null, null);
  }

  private RestfulResponse(int code, String message) {
    this(code, message, null);
  }

  private RestfulResponse(int code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  // Methods to Override.

  //  java.lang.Object
  //==========================================================================//

//  /** {@inheritDoc} */
//  @Override
//  public String toString() {
//    try {
//      ObjectMapper objectMapper = new ObjectMapper();
//      return objectMapper.writeValueAsString(this);
//    } catch (JsonProcessingException e) {
//      return super.toString();
//    }
//  }

  // Getters & Setters.

  public int getCode() {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return this.data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
