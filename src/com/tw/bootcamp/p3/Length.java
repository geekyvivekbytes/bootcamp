package com.tw.bootcamp.p3;

import java.util.Objects;

public class Length {

  private static final double DELTA = 0.001;
  private final double value;
  private final LengthUnit conversionLengthUnit;

  private Length(double value, LengthUnit conversionLengthUnit) {
    this.value = value;
    this.conversionLengthUnit = conversionLengthUnit;
  }

  private static Length create(double value, LengthUnit converstionLengthUnit) throws InvalidLength {
    if (value < 0) {
      throw new InvalidLength("Length can't be negative: " + value);
    }
    return new Length(value, converstionLengthUnit);
  }

  public static Length createInch(double value) throws InvalidLength {
    return Length.create(value, LengthUnit.INCH);
  }

  public static Length createFeet(double value) throws InvalidLength {
    return Length.create(value, LengthUnit.FEET);
  }

  public static Length createCentiMeter(double value) throws InvalidLength {
    return Length.create(value, LengthUnit.CM);
  }

  public static Length createMilliMeter(double value) throws InvalidLength {
    return  Length.create(value, LengthUnit.MM);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Length length)) return false;
    return Math.abs(length.toMeter() - toMeter()) < DELTA;
  }

  private double toMeter() {
    return conversionLengthUnit.value * value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, conversionLengthUnit);
  }

  @Override
  public String toString() {
    return "Length{" +
            "value=" + value +
            ", conversionUnit=" + conversionLengthUnit +
            '}';
  }
}
