package com.tw.bootcamp.p3;

import java.util.Objects;

public class Length {

  private static final double DELTA = 0.001;
  private final double value;
  private final LengthUnit unit;

  private Length(double value, LengthUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  private static Length create(double value, LengthUnit unit) throws InvalidLength {
    if (value < 0) {
      throw new InvalidLength("Length can't be negative: " + value);
    }
    return new Length(value, unit);
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
    return Length.create(value, LengthUnit.MM);
  }

  private double toMeter() {
    return unit.value * value;
  }

  public Length add(Length other) throws InvalidLength, IncompatibleUnits {
    if (!unit.equals(other.unit))
      throw new IncompatibleUnits("Different units cannot be added: " + unit + ", " + other.unit);
    return create(this.value + other.value, this.unit);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Length length)) return false;
    return Math.abs(length.toMeter() - toMeter()) < DELTA;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }

  @Override
  public String toString() {
    return "Length{" +
            "value=" + value +
            ", conversionUnit=" + unit +
            '}';
  }
}
