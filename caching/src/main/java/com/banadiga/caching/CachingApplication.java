package com.banadiga.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class CachingApplication {
  public static void main(String[] args) {
    SpringApplication.run(CachingApplication.class, args);
  }
}
