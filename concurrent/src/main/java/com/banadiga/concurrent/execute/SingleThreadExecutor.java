package com.banadiga.concurrent.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor implements IExecutor {

  private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

  @Override
  public void run() {
    singleThreadExecutor.execute(new MyRunnable("r-03"));
    singleThreadExecutor.execute(new MyRunnable("r-04"));
    singleThreadExecutor.execute(new MyThread("t-03"));
    singleThreadExecutor.execute(new MyThread("t-04"));

    singleThreadExecutor.shutdown();
  }
}
