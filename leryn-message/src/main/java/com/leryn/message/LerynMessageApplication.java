package com.leryn.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@SpringBootApplication(scanBasePackages = {"com.leryn.base", "com.leryn.message"})
public class LerynMessageApplication {

  public static void main(String[] args) {
    SpringApplication.run(LerynMessageApplication.class, args);
  }

}
