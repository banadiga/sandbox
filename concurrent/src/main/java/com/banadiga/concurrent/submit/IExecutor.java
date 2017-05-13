package com.banadiga.concurrent.submit;

import java.util.concurrent.Future;

public interface IExecutor {
  Future<?> run();
  void close();
}
