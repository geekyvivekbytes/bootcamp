package com.tw.bootcamp.p5;

public class Ball {
  private final Color color;

  public Ball(Color color) {
    this.color = color;
  }

  public boolean isSameColor(Color color) {
    return this.color.equals(color);
  }
}
