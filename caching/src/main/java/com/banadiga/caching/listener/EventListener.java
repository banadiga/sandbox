package com.banadiga.caching.listener;

import lombok.extern.slf4j.Slf4j;

import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventListener implements ItemListener<String> {

  @Override
  public void itemAdded(ItemEvent<String> item) {
    log.info("ItemEvent {}", item);
  }

  @Override
  public void itemRemoved(ItemEvent<String> item) {
    log.info("ItemEvent {}", item);
  }
}
