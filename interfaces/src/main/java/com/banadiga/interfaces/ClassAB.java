package com.banadiga.interfaces;

public class ClassAB implements InterfaceA, InterfaceB {
  @Override
  public void test() {
    System.out.println("ClassAB");
  }
}
