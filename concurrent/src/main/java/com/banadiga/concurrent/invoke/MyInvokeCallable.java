package com.banadiga.concurrent.invoke;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class MyInvokeCallable implements Callable<String> {

  private String id;

  public MyInvokeCallable(String id) {
    this.id = id;
  }

  @Override
  public String call() {
    try {
      sleep(1000);
    } catch (InterruptedException e) {
      // handle exception here
    }
    Thread t = Thread.currentThread();
    String name = t.getName();
    System.out.println("[MyInvokeCallable] Asynchronous task id = " + id + ". Thread name=" + name);
    return id;
  }
}
