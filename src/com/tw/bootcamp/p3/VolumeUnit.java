package com.tw.bootcamp.p3;

public enum VolumeUnit {
  GALLON(3.78541),
  LITER(1);


  public final double value;

  VolumeUnit(double value) {
    this.value = value;
  }
}
