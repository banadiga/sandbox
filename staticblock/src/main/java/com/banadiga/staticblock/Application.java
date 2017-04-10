package com.banadiga.staticblock;

public class Application {
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

  public Application() {
    singleton = Singleton.getInstance();
  }

  public static void main(String[] args) {
    Application application = new Application();
    application.singleton.run();
    Singleton.getInstance().run();
    SingletonWithHolder.getInstance().run();
  }
}


