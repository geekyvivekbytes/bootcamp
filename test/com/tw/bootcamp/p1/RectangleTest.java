package com.tw.bootcamp.p1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
  @Test
  void itShouldCalculateAreaOfRectangle() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.createRectangle(4,5);
    assertEquals(20,rectangle.area());
  }

  @Test
  void itShouldCalculateAreaIfDimensionInDecimalOfRectangle() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.createRectangle(1.2,5);
    assertEquals(6.0,rectangle.area());
  }

  @Test
  void itShouldReturnZeroIfAnyDimensionIsZero() throws InvalidDimensionException {
    assertEquals(0,Rectangle.createRectangle(0,10).area());
    assertEquals(0,Rectangle.createRectangle(10,0).area());
    assertEquals(0,Rectangle.createRectangle(0,0).area());
  }

  @Test
  void itShouldThrowAnErrorWhenNegativeValueIsProvidedToCreateRectangleRectangle() {
    assertThrows(InvalidDimensionException.class,() -> Rectangle.createRectangle(-1,10));
  }

  @Test
  void itShouldCalculatePerimeterOfRectangle() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.createRectangle(5, 4);
    assertEquals(18,rectangle.perimeter());
  }

  @Test
  void itShouldCalculatePerimeterOfRectangleWhenDimensionIsInDecimal() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.createRectangle(5.8, 4.1);
    assertEquals(19.8,rectangle.perimeter(),0.1);
  }



  @Test
  void itShouldReturnTwiceOfLengthAsBreadthIsZero() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.createRectangle(4, 0);
    assertEquals(8,rectangle.perimeter());
  }

  @Test
  void itShouldCreateRectangleSquareAndCalculateArea() throws InvalidDimensionException {
    Rectangle square = Rectangle.createSquare(5);

    assertEquals(25,square.area());
  }

  @Test
  void itShouldCalculateThePerimeterOfSquare() throws InvalidDimensionException {
    Rectangle square = Rectangle.createSquare(5);
    assertEquals(20,square.perimeter());
  }

  @Test
  void itShouldThrowError() {
    assertThrows(InvalidDimensionException.class,() ->Rectangle.createSquare(-5));
  }
}