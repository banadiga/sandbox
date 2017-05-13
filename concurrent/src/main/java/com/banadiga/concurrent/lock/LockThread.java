package com.banadiga.concurrent.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class LockThread extends Thread {

  private static Semaphore semaphore = new Semaphore(5);
  private String id;

  public LockThread(String id) {
    setDaemon(true);
    this.id = id;
  }

  @Override
  public void run() {
    Thread t = Thread.currentThread();
    String name = t.getName();

    boolean permit = false;
    while (true) {
      try {
        permit = semaphore.tryAcquire(5, TimeUnit.SECONDS);
        if (permit) {
          System.out.println("Semaphore acquired Lock " + id);
          System.out.println("name= " + name);
          sleep(50);
        } else {
          System.out.println("Could not acquire semaphore Lock " + id);
        }
      } catch (InterruptedException e) {
        // handle exception here
      } finally {
        if (permit) {
          semaphore.release();
        }
      }
    }
  }
}
