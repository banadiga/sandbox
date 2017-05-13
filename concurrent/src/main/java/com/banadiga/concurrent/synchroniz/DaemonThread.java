package com.banadiga.concurrent.synchroniz;

public class DaemonThread extends Thread {

  static Integer count = 0;

  public DaemonThread() {
    setDaemon(true);
  }

  @Override
  public void run() {


    while (true) {
      System.out.println("Hello from synchronized " + count);

      inc();

      try {
        sleep(500);
      } catch (InterruptedException e) {
        // handle exception here
      }
    }
  }

  private synchronized void inc() {
    count = count + 1;
  }
}
