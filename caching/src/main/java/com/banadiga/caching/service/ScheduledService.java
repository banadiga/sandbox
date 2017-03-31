package com.banadiga.caching.service;

import lombok.extern.slf4j.Slf4j;

import com.banadiga.caching.dto.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class ScheduledService {

  private static final String ID = "a55f08fd-be35-442c-98c8-844619516e22";

  private SecureRandom random = new SecureRandom();

  @Autowired
  private ItemService itemService;

  private String nextString(int radix) {
    return new BigInteger(130, random).toString(radix);
  }

  @PostConstruct
  public void init() {
    itemService.add(ID, Item.builder().name(nextString(64)).code(nextString(32)).build());
    log.info("Count : {}", itemService.list().size());
  }

  @Scheduled(initialDelay = 30000, fixedDelay = 1000)
  public void createData() {
    for (int i = 0; i < random.nextInt(); i++) {
      itemService.add(Item.builder().name(nextString(64)).code(nextString(32)).build());
    }
  }
}
