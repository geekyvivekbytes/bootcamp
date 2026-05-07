package com.tw.bootcamp.p1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  void itShouldReturnPerimeter() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.create(5, 4);
    assertEquals(18,rectangle.perimeter());
  }

  @Test
  void itShouldReturnTwiceOfLengthAsBreadthIsZero() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.create(4, 0);
    assertEquals(8,rectangle.perimeter());
  }
}