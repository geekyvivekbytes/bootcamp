package com.tw.bootcamp.p2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChanceTest {
  @Test
  void testingACoinProbability() throws InvalidChance {
    Chance tailChance = Chance.create(0.5);
    assertEquals(Chance.create(0.5), tailChance);
  }


  @Test
  void itShouldThrowsAnError() {
    assertThrows(InvalidChance.class,() ->  Chance.create(2));
    assertThrows(InvalidChance.class,() ->  Chance.create(-1));
  }

  @Test
  void itShouldReturnNotOfChance() throws InvalidChance {
    Chance tailChance = Chance.create(0.6);
    Chance expectedChance = Chance.create(0.4);
    assertEquals(expectedChance,tailChance.not());
  }

  @Test
  void shouldBeAbleToRepresentChanceOfTails() throws InvalidChance {
    Chance chanceOfGettingTails = Chance.create(0.25);
    assertEquals(Chance.create(0.25), chanceOfGettingTails);
  }
}
