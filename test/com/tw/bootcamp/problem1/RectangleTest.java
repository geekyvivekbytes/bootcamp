package com.tw.bootcamp.problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  @Test
  void itShouldCalculateArea() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.create(4,5);
    assertEquals(20,rectangle.area());
  }

  @Test
  void itShouldReturnZeroIfAnyDimensionIsZero() throws InvalidDimensionException {
    assertEquals(0,Rectangle.create(0,10).area());
    assertEquals(0,Rectangle.create(10,0).area());
    assertEquals(0,Rectangle.create(0,0).area());
  }

  @Test
  void itShouldThrowAnErrorWhenNegativeValueIsProvidedToCreateRectangle() {
    assertThrows(InvalidDimensionException.class,() -> Rectangle.create(-1,10));
  }
}