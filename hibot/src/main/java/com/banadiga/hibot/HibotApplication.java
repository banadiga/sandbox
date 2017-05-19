package com.banadiga.hibot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.banadiga.hibot"})
public class HibotApplication {

  public static void main(String[] args) {
    SpringApplication.run(HibotApplication.class, args);
  }
}
