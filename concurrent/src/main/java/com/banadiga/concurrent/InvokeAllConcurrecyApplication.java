package com.banadiga.concurrent;

import com.banadiga.concurrent.invoke.FixedThreadPool;

import java.util.concurrent.ExecutionException;

public class InvokeAllConcurrecyApplication {

  private static FixedThreadPool fixedThreadPool = new FixedThreadPool();

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    fixedThreadPool.runAll().forEach(stringFuture -> {
      try {
        String string = stringFuture.get();
        System.out.println("Get: " + string);
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    });

    fixedThreadPool.close();
  }
}
