package com.banadiga.caching.service;

import lombok.extern.slf4j.Slf4j;

import com.banadiga.caching.dto.Item;
import com.hazelcast.core.IMap;
import com.hazelcast.core.ITopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.lang.Thread.sleep;
import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@CacheConfig(cacheNames = "itemsCache")
public class ItemService {

  @Autowired
  private IMap<String, Item> storage;

  @Autowired
  private ITopic<String> event;

  @CachePut(key = "#result.id")
  public Item create(Item item) {
    String id = UUID.randomUUID().toString();
    item.setId(id);

    log.info("creating {}", item);
    event.publish("creating");
    storage.put(id, item);
    return item;
  }

  @Cacheable
  public Item read(String id) {
    heavyLogic();

    log.info("reading {}", id);
    event.publish("reading");
    return storage.get(id);
  }

  @CachePut(key = "#id")
  public Item update(String id, Item item) {
    item.setId(id);

    log.info("updating {} {}", id, item);
    event.publish("updating");
    storage.put(id, item);
    return item;
  }

  @CacheEvict(key = "#id")
  public void delete(String id) {
    log.info("deleting {} {}", id);
    event.publish("deleting");
    storage.remove(id);
  }

  public List<Item> list() {
    log.info("listing");
    event.publish("listing");
    return storage.entrySet().stream()
        .map(Map.Entry::getValue)
        .collect(toList());
  }

  private void heavyLogic() {
    try {
      sleep(3000);
    } catch (InterruptedException e) {
      log.error(e.getLocalizedMessage());
    }
  }

  void add(String id, Item item) {
    item.setId(id);
    storage.put(id, item);
    log.info("putting {}", item);
  }

  void add(Item item) {
    add(UUID.randomUUID().toString(), item);
  }
}
