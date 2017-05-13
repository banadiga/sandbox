package com.banadiga.concurrent;

import com.banadiga.concurrent.lock.LockThread;

public class LockConcurrecyApplication {

  public static void main(String[] args) {

    try {
      new LockThread("id-1").start();
      new LockThread("id-2").start();
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // handle here exception
    }

    System.out.println("Main Thread ending");
  }
}
