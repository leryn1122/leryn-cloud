package com.leryn.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Data
@NoArgsConstructor
public class UserDetails {

  private String username;

  private String password;

  private boolean expired = false;

  private boolean locked = false;

  private boolean credentialExpired = false;

  private boolean enabled = true;

  public UserDetails(String username) {
    this.username = username;
  }

  public boolean isAccountNonExpired() {
    return !this.expired;
  }

  public boolean isAccountNonLocked() {
    return !this.locked;
  }

  public boolean isCredentialsNonExpired() {
    return !this.expired;
  }

  public boolean isEnabled() {
    return this.enabled;
  }
}
