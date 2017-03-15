package com.banadiga.coffeepattern;

public abstract class CoffeWith implements ICoffe {
  protected final ICoffe coffe;

  public CoffeWith(ICoffe coffe) {
    this.coffe = coffe;
  }

  @Override
  public double getSize() {
    return coffe.getSize();
  }
}
