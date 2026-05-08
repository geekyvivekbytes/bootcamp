package com.tw.bootcamp.p3;

public enum LengthUnit {
  INCH(1),
  FEET(12),
  CM(0.393701),
   MM(0.0393701);


  public final double value;

  LengthUnit(double value) {
    this.value = value;
  }
}
