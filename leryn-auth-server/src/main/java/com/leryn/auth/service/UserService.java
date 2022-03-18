package com.leryn.auth.service;

import com.leryn.auth.exception.UsernameNotFoundException;
import com.leryn.auth.model.UserDetails;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
public interface UserService {

  /**
   *
   * @param username
   * @return
   */
  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

  boolean verifyUserByCredential(String username, String password) throws UsernameNotFoundException;

}
