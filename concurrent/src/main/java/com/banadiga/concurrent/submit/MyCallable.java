package com.banadiga.concurrent.submit;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class MyCallable implements Callable<String> {

  private String id;

  public MyCallable(String id) {
    this.id = id;
  }

  @Override
  public String call() {
    try {
      sleep(2000);
    } catch (InterruptedException e) {
      // handle exception here
    }
    Thread t = Thread.currentThread();
    String name = t.getName();
    System.out.println("[MyCallable] Asynchronous task id = " + id + ". Thread name=" + name);
    return id;
  }
}
