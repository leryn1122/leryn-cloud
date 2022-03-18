package com.leryn.auth.util.cipher;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public interface CipherBase {

  String ENCODING = StandardCharsets.UTF_8.name();

  /**
   *
   * @param data 需要加密的数据
   * @param secureKey 密钥
   * @return 加密后的字符串
   */
  String encrypt(String data, String secureKey);

  /**
   *
   * @param data 需要解密的数据
   * @param secureKey 密钥
   * @return 解密后的字符串
   */
  String decrypt(String data, String secureKey);

  /**
   * @param secureKey 明文密钥
   * @return 获取密钥
   */
  SecretKeySpec getSecureKey(String secureKey);

  default Cipher getCipher(int cipherMode, String secureKey) throws GeneralSecurityException {
    Cipher cipher = Cipher.getInstance(getCipherAlgorithm());
    cipher.init(cipherMode, getSecureKey(secureKey));
    return cipher;
  }

  /**
   * 返回算法的名称, 例如AES/xxx
   * @see #getCipher(int, String)
   */
  String getCipherAlgorithm();

}
