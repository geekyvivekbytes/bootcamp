package com.tw.bootcamp.p2;

import java.util.Objects;

public class Chance {
  public static final int MIN_CHANCE = 0;
  public static final int MAX_CHANCE = 1;
  private final double chance;

  public Chance(double chance) {
    this.chance = chance;
  }

  public static Chance create(double chance) throws InvalidChance {
    if (chance < MIN_CHANCE || chance > MAX_CHANCE) {
      throw  new InvalidChance(chance + " is a invalid chance value");
    }
    return  new Chance(chance);
  }

  public Chance not() throws InvalidChance {
    return Chance.create(MAX_CHANCE - chance);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Chance chance1)) return false;
    return Double.compare(chance, chance1.chance) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(chance);
  }
}
