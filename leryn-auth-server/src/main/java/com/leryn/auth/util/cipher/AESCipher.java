package com.leryn.auth.util.cipher;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.lang.Nullable;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public class AESCipher implements CipherBase {

  private static final String KEY_ALGORITHM = "AES";
  private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

  @Nullable
  @Override
  public String encrypt(String data, String secureKey) {
    try {
      byte[] byteContent = data.getBytes(ENCODING);
      Cipher cipher = getCipher(Cipher.ENCRYPT_MODE, secureKey);
      byte[] result = cipher.doFinal(byteContent);
      return Base64.encodeBase64String(result);
    } catch (GeneralSecurityException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Nullable
  @Override
  public String decrypt(String data, String secureKey) {
    try {
      Cipher cipher = getCipher(Cipher.DECRYPT_MODE, secureKey);
      byte[] result = cipher.doFinal((Base64.decodeBase64(data)));
      return new String(result, ENCODING);
    } catch (GeneralSecurityException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public SecretKeySpec getSecureKey(String secureKey) {
    SecretKeySpec secretKeySpec = null;
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
      SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
      secureRandom.setSeed(secureKey.getBytes(ENCODING));
      keyGenerator.init(1<<7, secureRandom);
      SecretKey secretKey = keyGenerator.generateKey();
      byte[] secretKeyEncoded = secretKey.getEncoded();
      secretKeySpec = new SecretKeySpec(secretKeyEncoded, KEY_ALGORITHM);
    } catch (GeneralSecurityException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return secretKeySpec;
  }

  @Override
  public String getCipherAlgorithm() {
    return CIPHER_ALGORITHM;
  }
}
