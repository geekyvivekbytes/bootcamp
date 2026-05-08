package com.tw.bootcamp.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TemperatureTest {
  @Test
  void shouldCompareTwoDifferentTemperatures() {
    Temperature celsius = Temperature.createCelsius(100.0);
    Temperature fahrenheit = Temperature.createFahrenheit(212.0);
    assertEquals(celsius, fahrenheit);
  }
}
