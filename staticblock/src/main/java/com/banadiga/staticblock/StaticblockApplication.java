package com.banadiga.staticblock;

public class StaticblockApplication {
  private Singleton singleton;

  {
    System.out.println("Hello World 2");
  }

  static {
    System.out.println("Hello World 1");
  }

  {
    System.out.println("Hello World 3");
  }

  public StaticblockApplication() {
    singleton = Singleton.getInstance();
  }

  public static void main(String[] args) {
    StaticblockApplication application = new StaticblockApplication();
    application.singleton.run();
    Singleton.getInstance().run();
    SingletonWithHolder.getInstance().run();
  }
}


