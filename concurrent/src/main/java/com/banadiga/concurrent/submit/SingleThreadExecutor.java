package com.banadiga.concurrent.submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutor implements IExecutor {

  private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

  @Override
  public Future<String> run() {
    return singleThreadExecutor.submit(new MyCallable("c-03"));
  }

  @Override
  public void close() {
    singleThreadExecutor.shutdown();
  }
}
