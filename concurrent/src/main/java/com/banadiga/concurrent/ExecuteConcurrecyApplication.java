package com.banadiga.concurrent;

import com.banadiga.concurrent.execute.FixedThreadPool;
import com.banadiga.concurrent.execute.ScheduledThreadPool;
import com.banadiga.concurrent.execute.SingleThreadExecutor;

public class ExecuteConcurrecyApplication {

  private static FixedThreadPool fixedThreadPool = new FixedThreadPool();
  private static ScheduledThreadPool scheduledThreadPool = new ScheduledThreadPool();
  private static SingleThreadExecutor singleThreadExecutor = new SingleThreadExecutor();

  public static void main(String[] args) {
    fixedThreadPool.run();
    scheduledThreadPool.run();
    singleThreadExecutor.run();
  }
}
