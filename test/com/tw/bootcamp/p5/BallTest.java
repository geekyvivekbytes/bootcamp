package com.tw.bootcamp.p5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BallTest {

  @Test
  void itShouldReturnTrueIfCheckedSameColor() {
    Ball ball = new Ball(Color.BLUE);
    assertTrue(ball.isSameColor(Color.BLUE));
    assertFalse(ball.isSameColor(Color.GREEN));
  }
}