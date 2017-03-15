package com.banadiga.coffeepattern;

public class Cappuccino extends CoffeWith {
  private double milk = 100d;

  public Cappuccino(Espresso coffe) {
    super(coffe);
  }

  @Override
  public double getSize() {
    return super.getSize() + milk;
  }
}
