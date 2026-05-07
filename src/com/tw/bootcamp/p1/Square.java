package com.tw.bootcamp.p1;

public class Square {
  private final int side;

  public Square(int side) {
    this.side = side;
  }

  public static Square create(int side) throws InvalidDimensionException {
    if(side < 0) {
      throw new InvalidDimensionException("Side should not be negative");
    }
    return new Square(side);
  }


  public int area() {
    return side * side;
  }

  public int perimeter() {
    return 4 * side;
  }
}
