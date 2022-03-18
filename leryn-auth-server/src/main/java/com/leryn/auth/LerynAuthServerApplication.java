package com.leryn.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@SpringBootApplication(scanBasePackages = {"com.leryn.base", "com.leryn.auth"})
public class LerynAuthServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(LerynAuthServerApplication.class, args);
  }
}
