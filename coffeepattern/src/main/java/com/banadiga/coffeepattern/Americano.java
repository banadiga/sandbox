package com.banadiga.coffeepattern;

public class Americano extends CoffeWith {
  private double water = 100d;

  public Americano(Espresso coffe) {
    super(coffe);
  }

  @Override
  public double getSize() {
    return super.getSize() + water;
  }
}
