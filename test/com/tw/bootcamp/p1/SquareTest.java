package com.tw.bootcamp.p1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
  @Test
  void itShouldReturnAreaOfSquare() throws InvalidDimensionException {
    Square square = Square.create(5);
    assertEquals(25,square.area());
  }

  @Test
  void itShouldReturnPerimeter() throws InvalidDimensionException {
    Square square = Square.create(5);
    assertEquals(20,square.perimeter());
  }

  @Test
  void itShouldReturnPerimeterAndAreaZeroIfSideIsZero() throws InvalidDimensionException {
    Square square = Square.create(0);
    assertEquals(0,square.perimeter());
    assertEquals(0,square.area());
  }

  @Test
  void itShouldThrowAnErrorIfSideIsLessThanZero() {
    assertThrows(InvalidDimensionException.class,() -> Square.create(-4));
  }
}
