package com.banadiga.caching.controller;

import com.banadiga.caching.dto.Item;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.ITopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/info", produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType
    .APPLICATION_JSON_VALUE})
public class InfoController {

  @Autowired
  private ITopic<String> event;
  @Autowired
  private CacheManager itemsCache;
  @Autowired
  private IMap<String, Item> storage;
  @Autowired
  private IQueue<String> queue;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String info() {

    Map iCache = (Map) itemsCache.getCache("itemsCache").getNativeCache();

    StringBuilder iCacheString = new StringBuilder();
    iCache.forEach((i, b) -> iCacheString.append(" (" + i + ", " + b + ")"));

    return "System info:" + "\n" +
           "\n" +
           "Event: " + event.getName() + "\n" +
           " Info: " + event.getLocalTopicStats() + "\n" +
           "\n" +
           "ItemsCache: " + itemsCache.getCacheNames() + "\n" +
           " - ItemsCache :" + iCache + "\n" +
           " - Size :" + iCache.size() + "\n" +
           " - : " + iCacheString + "\n" +
           "\n" +
           "Storage: " + storage.getName() + "\n" +
           " Size: " + storage.size() + "\n" +
           "\n" +
           "Queue: " + queue.getName() + "\n" +
           " Size: " + queue.size() + "\n" +
           "\n";
  }
}
