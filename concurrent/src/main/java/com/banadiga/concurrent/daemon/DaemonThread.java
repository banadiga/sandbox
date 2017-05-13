package com.banadiga.concurrent.daemon;

public class DaemonThread extends Thread {

  public DaemonThread() {
    setDaemon(true);
  }

  @Override
  public void run() {
    int count = 0;

    while (true) {
      System.out.println("Hello from Daemon Thread " + count++);

      try {
        sleep(5000);
      } catch (InterruptedException e) {
        // handle exception here
      }
    }
  }
}
