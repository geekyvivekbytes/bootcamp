package com.tw.bootcamp.p4;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingLot {
  private final int capacity;
  private final ArrayList<Vehicle> parkingArea;

  public ParkingLot(int capacity) {
    this.capacity = capacity;
    this.parkingArea = new ArrayList<>();
  }

  public void park(Vehicle vehicle) throws CapacityFullException {
    if (isFull()) throw new CapacityFullException();
    parkingArea.add(vehicle);
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

  public boolean isFull() {
    return parkingArea.size() >= capacity;
  }
}
