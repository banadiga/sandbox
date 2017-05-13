package com.banadiga.concurrent.invoke;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface IExecutor {
  String runAny() throws ExecutionException, InterruptedException;

  List<Future<String>> runAll() throws ExecutionException, InterruptedException;

  void close();
}
