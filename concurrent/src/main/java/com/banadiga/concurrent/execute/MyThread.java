package com.banadiga.concurrent.execute;

public class MyThread extends Thread {
  private String id;

  public MyThread(String id) {
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
    System.out.println("[MyThread] Asynchronous task id = " + id + ". Thread name=" + name);
  }
}
