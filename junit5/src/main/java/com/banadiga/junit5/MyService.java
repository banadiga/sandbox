package com.banadiga.junit5;

import org.springframework.stereotype.Service;

@Service
public class MyService {

  public String getMessage(String name) {
    if ("oh".equals(name)) {
      throw new RuntimeException("oh?");
    } else if (name.length() > 3) {
      return "Hi " + name;
    }
    return "Hello " + name;
  }
}
