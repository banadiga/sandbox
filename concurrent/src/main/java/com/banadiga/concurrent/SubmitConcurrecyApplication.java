package com.banadiga.concurrent;

import com.banadiga.concurrent.submit.FixedThreadPool;
import com.banadiga.concurrent.submit.ScheduledThreadPool;
import com.banadiga.concurrent.submit.SingleThreadExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SubmitConcurrecyApplication {

  private static FixedThreadPool fixedThreadPool = new FixedThreadPool();
  private static ScheduledThreadPool scheduledThreadPool = new ScheduledThreadPool();
  private static SingleThreadExecutor singleThreadExecutor = new SingleThreadExecutor();

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Future<String> future1 = fixedThreadPool.run();
    Future<String> future2 = fixedThreadPool.run();

    Future<?> future3 = scheduledThreadPool.run();
    Future<?> future4 = scheduledThreadPool.run();

    Future<String> future5 = singleThreadExecutor.run();
    Future<String> future6 = singleThreadExecutor.run();


    System.out.println("Future get: " + future1.get());
    System.out.println("Future get: " + future2.get());
    System.out.println("Future get: " + future3.get());
    System.out.println("Future get: " + future4.get());
    System.out.println("Future get: " + future5.get());
    System.out.println("Future get: " + future6.get());

    fixedThreadPool.close();
    scheduledThreadPool.close();
    singleThreadExecutor.close();
  }
}
