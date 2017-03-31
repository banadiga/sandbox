package com.banadiga.caching.listener;

import lombok.extern.slf4j.Slf4j;

import com.hazelcast.core.IQueue;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicMessageListener implements MessageListener<String> {

  @Autowired
  private IQueue<String> queue;

  @Override
  public void onMessage(Message<String> message) {
    log.info("Message: {}", message.getMessageObject());
    queue.add(message.getMessageObject());
  }
}
