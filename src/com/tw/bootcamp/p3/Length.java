package com.tw.bootcamp.p3;

import java.util.Map;
import java.util.Objects;

public class Length {

  private static final double DELTA = 0.001;
  private final double value;
  private final Unit conversionUnit;

  private Length(double value, Unit conversionUnit) {
    this.value = value;
    this.conversionUnit = conversionUnit;
  }

  private static Length create(double value, Unit converstionUnit) throws InvalidLength {
    if (value < 0) {
      throw new InvalidLength("Length can't be negative: " + value);
    }
    return new Length(value, converstionUnit);
  }

  public static Length createInch(double value) throws InvalidLength {
    return Length.create(value, Unit.INCH);
  }

  public static Length createFeet(double value) throws InvalidLength {
    return Length.create(value, Unit.FEET);
  }

  public static Length createCentiMeter(double value) throws InvalidLength {
    return Length.create(value, Unit.CM);
  }

  public static Length createMilliMeter(int value) throws InvalidLength {
    return  Length.create(value,Unit.MM);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Length length)) return false;
    return Math.abs(length.toMeter() - toMeter()) < DELTA;
  }

  private double toMeter() {
    return conversionUnit.value * value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, conversionUnit);
  }

  @Override
  public String toString() {
    return "Length{" +
            "value=" + value +
            ", conversionUnit=" + conversionUnit +
            '}';
  }
}
