package com.banadiga.concurrent;

import com.banadiga.concurrent.synchroniz.DaemonThread;

public class SynchronizConcurrecyApplication {

  public static void main(String[] args) {

    try {
      new DaemonThread().start();
      Thread.sleep(1000);
      new DaemonThread().start();
      Thread.sleep(12000);
    } catch (InterruptedException e) {
      // handle here exception
    }

    System.out.println("Main Thread ending");
  }
}
