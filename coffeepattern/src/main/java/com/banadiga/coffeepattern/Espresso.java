package com.banadiga.coffeepattern;

public class Espresso implements ICoffe {
  private double water = 97.8d;

  @Override
  public double getSize() {
    return this.water;
  }
}
