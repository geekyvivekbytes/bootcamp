package com.tw.bootcamp.p4;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
  Map<String, ParkingLot> parkingLots;

  public ParkingSystem() {
    parkingLots = new HashMap<>();
  }

  public void add(String parkingLotId, ParkingLot parkingLot) {
    parkingLots.put(parkingLotId, parkingLot);
  }

  public void park(String parkingId, Car car) throws CapacityFullException {
    parkingLots.get(parkingId).park(car);
  }

  public boolean isLotFull(String parkingId) {
    return parkingLots.get(parkingId).isFull();
  }
}

