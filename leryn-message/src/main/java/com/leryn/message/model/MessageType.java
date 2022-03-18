package com.leryn.message.model;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public enum MessageType {
  /**
   * 短信服务
   */
  @Deprecated
  SMS,
  /**
   * 邮箱服务
   */
  EMAIL,
  /**
   * 微信公众号
   */
  WECHAT,
}
