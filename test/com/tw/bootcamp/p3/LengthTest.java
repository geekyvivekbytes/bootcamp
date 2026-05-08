package com.tw.bootcamp.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    assertEquals(centiMeter, inch);
  }

  @Test
  void itShouldNotEquals() throws InvalidLength {
    Length length1 = Length.createInch(2);
    Length length2 = Length.createInch(4);
    assertNotEquals(length1, length2);
    assertNotEquals(length2, length1);
  }

  @Test
  void itShouldComparesCMAndMM() throws InvalidLength {
    Length milliMeter = Length.createMilliMeter(10);
    Length centiMeter = Length.createCentiMeter(1);
    assertEquals(centiMeter, milliMeter);
    assertEquals(milliMeter, centiMeter);
  }

  @Test
  void itShouldAddTwoLengthOfSameUnit() throws InvalidLength {
    Length twoInches = Length.createInch(2);
    Length threeInches = Length.createInch(3);
    Length fiveInches = twoInches.add(threeInches);
    assertEquals(Length.createInch(5), fiveInches);
  }

  @Test
  void itShouldAddTwoDifferentUnitAndReturnInches() throws InvalidLength {
    Length twoInches = Length.createInch(2);
    Length twoAndHalfCM = Length.createCentiMeter(2.5);
    assertEquals(Length.createInch(3), twoInches.add(twoAndHalfCM));
    assertEquals(Length.createInch(3), twoAndHalfCM.add(twoInches));
  }
}
