package com.banadiga.staticblock;

public class Singleton {

  private static volatile Singleton instance = null;

  {
    System.out.println("Hello World 5");
  }

  static {
    System.out.println("Hello World 4");
  }

  {
    System.out.println("Hello World 6");
  }

  public Singleton() {
    System.out.println("Hello World Singleton");
  }

  public static Singleton getInstance() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }

  public void run() {
    System.out.println("RUN Singleton");
  }

}
