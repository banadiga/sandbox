package com.banadiga.concurrent.submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ScheduledThreadPool implements IExecutor {

  private ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

  @Override
  public Future<?> run() {
    return scheduledThreadPool.submit(new MyCallable("c-02"));
  }

  @Override
  public void close() {
    scheduledThreadPool.shutdown();
  }
}
