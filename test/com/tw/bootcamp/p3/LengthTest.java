package com.tw.bootcamp.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LengthTest {

  @Test
  void itShouldThrowsAnError() {
    assertThrows(InvalidLength.class, () -> Length.createInch(-1));
  }

  @Test
  void shouldCompareInchesToFeet() throws InvalidLength {
    Length inch = Length.createInch(12);
    Length feet = Length.createFeet(1);
    assertEquals(inch, feet);
  }

  @Test
  void itShouldComparesInchesToCentiMeter() throws InvalidLength {
    Length inch = Length.createInch(2);
    Length centiMeter = Length.createCentiMeter(5);
    assertEquals(inch, centiMeter);
  }
}
