package com.banadiga.caching;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class ScheduledService {

  public static final UUID ID = UUID.fromString("a55f08fd-be35-442c-98c8-844619516e22");
  @Autowired
  private MyService myService;

  private SecureRandom random = new SecureRandom();

  private String nextString(int radix) {
    return new BigInteger(130, random).toString(radix);
  }

  @PostConstruct
  public void init() {
    myService.add(ID, new MyDto(nextString(64), nextString(32)));
    log.info("Count : {}", myService.list().size());
  }

  @Scheduled(initialDelay = 15000, fixedDelay = 10000)
  public void createData() {
    for (int i = 0; i < 1000; i++) {
      myService.add(new MyDto(nextString(64), nextString(32)));
    }
    log.info("Count : {}", myService.list().size());
  }
}
