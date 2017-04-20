package com.banadiga.jlvsac;

import java.util.concurrent.atomic.AtomicInteger;

public class JlvsacApplication {

  private static void go(final Runnable runnable) {
    runnable.run();
  }

  private static long test(final Runnable runnable) {
    long startTime = System.nanoTime();
    for (int i = 0; i < 1000000; i++) {
      runnable.run();
    }
    return (System.nanoTime() - startTime) / 1000000;
  }

  public static void main(String[] args) {
    final AtomicInteger count = new AtomicInteger(0);

    long duration1 = test(() -> {
      Runnable runnable = new Runnable() {
        @Override
        public void run() {
          System.out.println("Count: " + count.incrementAndGet() + ". new Anonymous classes: " + this.toString());
        }
      };
      go(runnable);
    });

    long duration2 = test(() ->
        go(new Runnable() {
          @Override
          public void run() {
            Integer count = 5;
            System.out.println("Count: " + count + ". Anonymous classes: " + this.toString());
          }
        })
    );

    long duration3 = test(() ->
        go(() -> {
          //int count = 5; //compilation error
          System.out.println("Count: " + count.incrementAndGet() + ". Java8 Lambdas");
        })
    );

    long duration4 = test(() -> System.out.println("Count: " + count.incrementAndGet() + ". Java8 Lambdas"));

    System.out.println("Durations:");
    System.out.println("duration1: " + duration1);
    System.out.println("duration2: " + duration2);
    System.out.println("duration3: " + duration3);
    System.out.println("duration4: " + duration4);
  }
}
