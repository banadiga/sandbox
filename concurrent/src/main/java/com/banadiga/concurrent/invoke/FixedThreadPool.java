package com.banadiga.concurrent.invoke;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPool implements IExecutor {
  private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
  private Set<Callable<String>> callables = new HashSet<Callable<String>>();

  public FixedThreadPool() {
    callables.add(new MyInvokeCallable("c-01"));
    callables.add(new MyInvokeCallable("c-02"));
    callables.add(new MyInvokeCallable("c-03"));
    callables.add(new MyInvokeCallable("c-04"));
    callables.add(new MyInvokeCallable("c-05"));
    callables.add(new MyInvokeCallable("c-06"));
  }

  @Override
  public String runAny() throws ExecutionException, InterruptedException {
    return fixedThreadPool.invokeAny(callables);
  }


  @Override
  public List<Future<String>> runAll() throws ExecutionException, InterruptedException {
    return fixedThreadPool.invokeAll(callables);
  }

  @Override
  public void close() {
    fixedThreadPool.shutdown();
  }
}
