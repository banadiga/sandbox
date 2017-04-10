package com.banadiga.staticblock;

public class SingletonWithHolder {

  {
    System.out.println("Hello World 8");
  }

  static {
    System.out.println("Hello World 7");
  }

  {
    System.out.println("Hello World 9");
  }

  public SingletonWithHolder() {
    System.out.println("Hello World SingletonWithHolder");
  }

  public static SingletonWithHolder getInstance() {
    return Holder.holder;
  }

  public void run() {
    System.out.println("RUN SingletonWithHolder");
  }

  public static class Holder {
    public static final SingletonWithHolder holder = new SingletonWithHolder();

    {
      System.out.println("Hello World never");
    }

    static {
      System.out.println("Hello World 10");
    }

    {
      System.out.println("Hello World never");
    }
  }
}
