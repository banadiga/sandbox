package com.banadiga.concurrent.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScheduledThreadPool implements IExecutor {

  private ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

  @Override
  public void run() {
    scheduledThreadPool.execute(new MyRunnable("r-05"));
    scheduledThreadPool.execute(new MyRunnable("r-06"));
    scheduledThreadPool.execute(new MyThread("t-05"));
    scheduledThreadPool.execute(new MyThread("t-06"));

    scheduledThreadPool.shutdown();
  }
}
