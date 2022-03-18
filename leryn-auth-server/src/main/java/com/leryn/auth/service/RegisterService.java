package com.leryn.auth.service;

import java.util.Random;
import javax.annotation.Resource;

import com.leryn.auth.data.tables.daos.UserDao;
import com.leryn.auth.data.tables.pojos.User;
import com.leryn.auth.util.cipher.Encryptions;
import com.leryn.auth.vo.RegisterFormVo;

import org.springframework.stereotype.Service;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Service
public class RegisterService {

  @Resource
  private UserDao userDao;

  public void registerNewUser(RegisterFormVo registerFormVo) {
    String password = registerFormVo.getPassword();
    String salt = Encryptions.salt();
    String encryptedPassword = Encryptions.encryptByAES(password + salt);

    User user = new User();
    user.setUserId(new Random().nextInt());
    user.setUsername(registerFormVo.getUsername());
    user.setPassword(encryptedPassword);
    user.setSalt(salt);

    userDao.insert(user);
  }
}
