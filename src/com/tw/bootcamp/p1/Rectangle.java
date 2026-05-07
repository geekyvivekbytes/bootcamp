package com.tw.bootcamp.p1;

public class Rectangle {

  private final double length;
  private final double breadth;

  private Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public static Rectangle createRectangle(double length, double breadth) throws InvalidDimensionException {
    if (length < 0 || breadth < 0) {
      throw new InvalidDimensionException("Negative Dimension are not allowed");
    }
    return new Rectangle(length, breadth);
  }

  public static Rectangle createSquare(double side) throws InvalidDimensionException {
    return createRectangle(side, side);
  }

  public double area() {
    return length * breadth;
  }

  public double perimeter() {
    return 2 * (length + breadth);
  }
}
