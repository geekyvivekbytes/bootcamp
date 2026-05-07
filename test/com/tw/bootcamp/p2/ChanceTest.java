package com.tw.bootcamp.p2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceTest {
  @Test
  void testingACoinProbability() {
    Chance tailChance = new Chance(50);
    assertEquals(50, tailChance.get());
  }

  @Test
  void testingNotOfCoinProbability() {
    Chance tailChance = new Chance(50);
    assertEquals(50, tailChance.not());
  }

  @Test
  void shouldGetProbabilityOfGetting3InDice() {
    Chance chanceOf3InDice = new Chance(16);
    assertEquals(0.16, chanceOf3InDice.getProbability(),0.01);
  }

}
