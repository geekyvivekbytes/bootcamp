package com.tw.bootcamp.p2;

import java.util.Objects;

public class Chance {
  private static final int MIN_CHANCE = 0;
  private static final int MAX_CHANCE = 1;
  private final double chance;

  private Chance(double chance) {
    this.chance = chance;
  }

  public static Chance create(double chance) throws InvalidChance {
    if (chance < MIN_CHANCE || chance > MAX_CHANCE) {
      throw new InvalidChance(chance + " is a invalid chance value");
    }
    return new Chance(chance);
  }

  private Chance createChance(double chance) {
    return new Chance(chance);
  }

  public Chance not() {
    return createChance(MAX_CHANCE - chance);
  }

  public Chance or(Chance otherChance) {
    return createChance(this.chance + otherChance.chance - this.and(otherChance).chance);
  }

  public Chance and(Chance otherChance) {
    return createChance(this.chance * otherChance.chance);
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

  public Chance orDemorgan(Chance other) {
    return (this.not().and(other.not())).not();
  }
}
