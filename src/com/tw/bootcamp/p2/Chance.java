package com.tw.bootcamp.p2;

public class Chance {
  private final int chance;

  public Chance(int chance) {
    this.chance = chance;
  }

  public int get() {
    return chance;
  }

  public int not() {
    return 100 - chance;
  }

  public double getProbability() {
    return (double) chance / 100;
  }
}
