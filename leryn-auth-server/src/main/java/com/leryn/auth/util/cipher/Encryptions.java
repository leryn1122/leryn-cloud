package com.leryn.auth.util.cipher;

import java.util.Random;

/**
 *
 *
 *
 * @author Leryn
 * @since Leryn 1.0.0
 */
public abstract class Encryptions {

  private static final char[] CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

  private static final String AES_PRIVATE_KEY = "EUtYYFBx0djinBxfioX7mw";

  /**
   * @return 生成8位随机盐
   */
  public static String salt() {
    Random random = new Random();
    int length = 1<<3;
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      sb.append(CHARS[random.nextInt(62)]);
    }
    return sb.toString();
  }

  public static String encryptByAES(String plaintext) {
    CipherBase cipherBase = new AESCipher();
    return cipherBase.encrypt(plaintext, AES_PRIVATE_KEY);
  }

  public static String decryptByAES(String encryptedText) {
    CipherBase cipherBase = new AESCipher();
    return cipherBase.decrypt(encryptedText, AES_PRIVATE_KEY);
  }

  private Encryptions() {
  }
}
