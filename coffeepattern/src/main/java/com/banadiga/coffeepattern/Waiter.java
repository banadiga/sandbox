package com.banadiga.coffeepattern;

public class Waiter {

  public ICoffe getNewAmericanoWithMilkSugar() {
    return new CoffeWithSugar(new AmericanoWithMilk(new Americano(new Espresso())));
  }

  public ICoffe getCoffe(String name) {
    switch (name.toLowerCase()) {
      case "espresso":
        return new Espresso();
      case "americano":
        return new Americano(new Espresso());
      default:
        throw new UnsupportedOperationException("I do not understand you");
    }
  }
}
