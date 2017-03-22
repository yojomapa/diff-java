package com.yojomapa.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yojomapa on 21/03/17.
 */
@SpringBootApplication(scanBasePackages = "com.yojomapa")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}