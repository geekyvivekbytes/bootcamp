package com.tw.bootcamp.p3;

import java.util.Objects;

public class Temperature {
  public static final double DELTA = 0.1;
  private final double value;
  private final TemperatureUnits temperatureUnits;

  public Temperature(double value, TemperatureUnits temperatureUnits) {
    this.value = value;
    this.temperatureUnits = temperatureUnits;
  }

  public static Temperature createCelsius(double value) {
    return create(value, TemperatureUnits.CELSIUS);
  }

  private static Temperature create(double value, TemperatureUnits temperatureUnits) {
    return  new Temperature(value, temperatureUnits);
  }

  public static Temperature createFahrenheit(double value) {
    return create(value, TemperatureUnits.FAHRENHEIT);
  }

  private double toBase() {
    if (temperatureUnits.equals(TemperatureUnits.CELSIUS)) {
      return (value * 9) / 5 + 32 ;
    }
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Temperature that)) return false;
    return Math.abs(toBase() - that.toBase()) < DELTA;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, temperatureUnits);
  }
}
