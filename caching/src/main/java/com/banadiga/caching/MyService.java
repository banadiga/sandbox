package com.banadiga.caching;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.sleep;

@Service
@Slf4j
public class MyService {

  private Map<UUID, MyDto> storage = new ConcurrentHashMap<>();

  public void create(MyDto myDto) {
    heavyLogic();

    UUID id = UUID.randomUUID();
    myDto.setId(id);

    log.info("creating {}", myDto);
    storage.put(id, myDto);
  }

  public MyDto read(UUID id) {
    log.info("reading {}", id);
    heavyLogic();

    return storage.get(id);
  }

  public void update(UUID id, MyDto myDto) {
    heavyLogic();

    myDto.setId(id);
    storage.put(id, myDto);
    log.info("updating {} {}", id, myDto);
  }

  public void delete(UUID id) {
    log.info("deleting {} {}", id);
    heavyLogic();

    storage.remove(id);
  }

  public Collection<MyDto> list() {
    log.info("listing");
    heavyLogic();

    return storage.values();
  }

  private void heavyLogic() {
    try {
      sleep(3000);
    } catch (InterruptedException e) {
      log.error(e.getLocalizedMessage());
    }
  }

  void add(UUID id, MyDto myDto) {
    myDto.setId(id);
    storage.put(id, myDto);
    log.info("putting {}", myDto);
  }

  void add(MyDto myDto) {
    add(UUID.randomUUID(), myDto);
  }
}
