package com.tw.bootcamp.p1;

public class Rectangle implements Shape {

  private final int length;
  private final int breadth;

  private Rectangle(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public static Rectangle create(int length, int breadth) throws InvalidDimensionException {
    if(length < 0 ||  breadth < 0) {
      throw new InvalidDimensionException("Negative Dimension are not allowed");
    }
    return new Rectangle(length,breadth);
  }

  @Override
  public int area() {
    return length * breadth;
  }

  @Override
  public int perimeter() {
    return 2 * (length + breadth);
  }
}
