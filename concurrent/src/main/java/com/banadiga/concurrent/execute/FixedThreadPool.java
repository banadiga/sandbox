package com.banadiga.concurrent.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool implements IExecutor {

  private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

  @Override
  public void run() {
    fixedThreadPool.execute(new MyRunnable("r-01"));
    fixedThreadPool.execute(new MyRunnable("r-02"));
    fixedThreadPool.execute(new MyThread("t-01"));
    fixedThreadPool.execute(new MyThread("t-02"));

    fixedThreadPool.shutdown();
  }
}
