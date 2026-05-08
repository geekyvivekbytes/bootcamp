package com.tw.bootcamp.p3;

public enum Unit {
  INCH(0.0254),
  FEET(0.3048),
  CM(0.01), MM(0.001);


  public final double value;

  Unit(double value) {
    this.value = value;
  }
}
