package com.tw.bootcamp.p4;

public class Assistant {
  private final ParkingSystemView parkingSystem;

  public Assistant(ParkingSystemView parkingSystem) {
    this.parkingSystem = parkingSystem;
  }

  public boolean isLotFull(String parkingLotId) {
    return parkingSystem.isLotFull(parkingLotId);
  }

  public String displayReport() {
    return parkingSystem.report();
  }
}
