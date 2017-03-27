package com.banadiga.junit5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTopService {

  @Autowired
  MyService myService;


  public String getTopMessage(String name) {
    return myService.getMessage(name) + "!!!";
  }
}
