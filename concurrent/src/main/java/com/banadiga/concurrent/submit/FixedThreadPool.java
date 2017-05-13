package com.banadiga.concurrent.submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPool implements IExecutor {

  private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

  @Override
  public Future<String> run() {
    return fixedThreadPool.submit(new MyCallable("c-01"));
  }

  @Override
  public void close() {
    fixedThreadPool.shutdown();
  }
}
