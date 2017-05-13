package com.banadiga.concurrent;

import com.banadiga.concurrent.invoke.FixedThreadPool;

import java.util.concurrent.ExecutionException;

public class InvokeAnyConcurrecyApplication {

  private static FixedThreadPool fixedThreadPool = new FixedThreadPool();

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("Get: " + fixedThreadPool.runAny());
    fixedThreadPool.close();
  }
}
