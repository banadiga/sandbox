package com.banadiga.concurrent.execute;

import static java.lang.Thread.sleep;

public class MyRunnable implements Runnable {

  private String id;

  public MyRunnable(String id) {
    this.id = id;
  }

  @Override
  public void run() {
    try {
      sleep(3000);
    } catch (InterruptedException e) {
      // handle exception here
    }
    Thread t = Thread.currentThread();
    String name = t.getName();
    System.out.println("[MyRunnable] Asynchronous task id = " + id + ". Thread name=" + name);
  }
}
