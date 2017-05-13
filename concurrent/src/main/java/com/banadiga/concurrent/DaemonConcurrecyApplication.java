package com.banadiga.concurrent;

import com.banadiga.concurrent.daemon.DaemonThread;

public class DaemonConcurrecyApplication {

  public static void main(String[] args) {
    new DaemonThread().start();

    try {
      Thread.sleep(12000);
    } catch (InterruptedException e) {
      // handle here exception
    }

    System.out.println("Main Thread ending");
  }
}
