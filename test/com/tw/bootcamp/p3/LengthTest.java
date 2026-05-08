package com.tw.bootcamp.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthTest {

  @Test
  void shouldCompareInchesToFeet() {
    Length inch = Length.createInch(12);
    Length feet = Length.createFeet(1);
    assertEquals(inch,feet);
  }

  @Test
  void itShouldComparesInchesToCentiMeter() {
    Length inch = Length.createInch(2);
    Length centiMeter = Length.createCentiMeter(5);
    assertEquals(inch,centiMeter);
  }
}
