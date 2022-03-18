package com.leryn.auth.service;

import java.util.List;
import javax.annotation.Resource;

import com.leryn.auth.data.Tables;
import com.leryn.auth.data.tables.daos.UserDao;
import com.leryn.auth.data.tables.pojos.Authority;
import com.leryn.auth.data.tables.pojos.User;
import com.leryn.auth.exception.UsernameNotFoundException;
import com.leryn.auth.model.UserDetails;
import com.leryn.auth.util.cipher.Encryptions;

import org.jooq.DSLContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserDao userDao;

  @Resource
  private DSLContext dsl;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = findUserByUsername(username);
    UserDetails userDetails = new UserDetails();
    BeanUtils.copyProperties(user, userDetails);
    return userDetails;
  }

  @Override
  public boolean verifyUserByCredential(String username, String password) throws UsernameNotFoundException {
    User user = findUserByUsername(username);
    String salt = user.getSalt();
    String encryptedPassword = Encryptions.encryptByAES(password + salt);
    return encryptedPassword.equals(user.getPassword());
  }

  protected User findUserByUsername(String username) throws UsernameNotFoundException {
    List<User> users = userDao.fetchByUsername(username);
    if (CollectionUtils.isEmpty(users)) {
      throw new UsernameNotFoundException("User not founded.");
    }
    return users.get(0);
  }

  protected List<Authority> getAuthorities(String username) {
    List<Authority> authorities = dsl.select(Tables.AUTHORITY.fields())
      .from(Tables.USER)
      .join(Tables.USER_ROLE_RELATION)
        .on(Tables.USER_ROLE_RELATION.USER_ID.eq(Tables.USER.USER_ID))
      .join(Tables.ROLE)
        .on(Tables.ROLE.ROLE_ID.eq(Tables.USER_ROLE_RELATION.ROLE_ID))
      .join(Tables.ROLE_AUTHORITY_RELATION)
        .on(Tables.ROLE.ROLE_ID.eq(Tables.USER_ROLE_RELATION.ROLE_ID))
      .join(Tables.AUTHORITY)
        .on(Tables.AUTHORITY.AUTHORITY_ID.eq(Tables.ROLE_AUTHORITY_RELATION.AUTHORITY_ID))
      .where(Tables.USER.USERNAME.eq(username))
      .fetchInto(Authority.class);
    return authorities;
  }

}
