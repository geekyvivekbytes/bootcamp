package com.tw.bootcamp.p4;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Objects;

public class ParkingLot {
  private final int capacity;
  private final ArrayList<Car> parkingArea;

  public ParkingLot(int capacity) {
    this.capacity = capacity;
    this.parkingArea = new ArrayList<>();
  }

  public static ParkingLot create(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity can't be negative");
    }
    return new ParkingLot(capacity);
  }

  public boolean isFull() {
    return parkingArea.size() >= capacity;
  }

  public void park(Car car) throws CapacityFullException {
    if (isFull()) throw new CapacityFullException();
    parkingArea.add(car);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ParkingLot that)) return false;
    return capacity == that.capacity && Objects.equals(parkingArea, that.parkingArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(capacity, parkingArea);
  }
}
