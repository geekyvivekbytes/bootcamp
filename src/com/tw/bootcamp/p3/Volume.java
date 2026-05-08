package com.tw.bootcamp.p3;

import java.util.Objects;


public class Volume {

  public static final double DELTA = 0.01;
  private final double value;
  private final VolumeUnit volumeUnit;

  public Volume(double value, VolumeUnit volumeUnit) {
    this.value = value;
    this.volumeUnit = volumeUnit;
  }

  private static Volume create(double value, VolumeUnit volumeUnit) throws InvalidVolume {
    if (value < 0) throw new InvalidVolume("Volume cannot be negative: " + value);
    return new Volume(value, volumeUnit);
  }

  public static Volume createLiter(double value) throws InvalidVolume {
    return Volume.create(value, VolumeUnit.LITER);
  }

  public static Volume createGallon(double value) throws InvalidVolume {
    return Volume.create(value, VolumeUnit.GALLON);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Volume volume)) return false;
    return Math.abs(volume.toLiter() - toLiter()) < DELTA;
  }

  private double toLiter() {
    return value * volumeUnit.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, volumeUnit);
  }

  @Override
  public String toString() {
    return "Volume{" +
            "value=" + value +
            ", unit=" + volumeUnit +
            '}';
  }
}
