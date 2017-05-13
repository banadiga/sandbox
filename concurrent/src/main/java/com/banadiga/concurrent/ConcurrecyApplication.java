package com.banadiga.concurrent;

import java.util.concurrent.ExecutionException;

public class ConcurrecyApplication {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    DaemonConcurrecyApplication.main(args);
    ExecuteConcurrecyApplication.main(args);
    InvokeAllConcurrecyApplication.main(args);
    InvokeAnyConcurrecyApplication.main(args);
    SubmitConcurrecyApplication.main(args);
  }
}
