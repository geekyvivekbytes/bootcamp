package com.tw.bootcamp.p3;

import java.util.Objects;

public class Length {

  private static final double DELTA = 0.01;
  public static final double INCH_TO_METER_UNIT = 0.0254;
  public static final double FEET_TO_METER = 0.3048;
  public static final double CM_TO_METER = 0.01;
  private final double value;
  private final double conversionUnit;

  private Length(double value, double conversionUnit) {
    this.value = value;
    this.conversionUnit = conversionUnit;
  }

  public static Length createInch(double value) {
    return new Length(value, INCH_TO_METER_UNIT);
  }


  public static Length createFeet(double value) {
    return new Length(value, FEET_TO_METER);
  }

  public static Length createCentiMeter(double value) {
    return new Length(value, CM_TO_METER);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Length length)) return false;
    return toMeter(length) - toMeter(this) < DELTA;
  }

  private static double toMeter(Length length) {
    return length.conversionUnit * length.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, conversionUnit);
  }
}
