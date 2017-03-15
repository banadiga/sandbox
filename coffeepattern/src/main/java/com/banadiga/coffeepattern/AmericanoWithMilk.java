package com.banadiga.coffeepattern;

public class AmericanoWithMilk extends CoffeWith {
  private double milk = 100d;

  public AmericanoWithMilk(Americano coffe) {
    super(coffe);
  }

  @Override
  public double getSize() {
    return super.getSize() + milk;
  }
}
