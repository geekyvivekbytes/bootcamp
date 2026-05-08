package com.tw.bootcamp.p4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingTest {
  @Test
  void parkShouldParkTheGivenCar() throws CapacityFullException {
    ParkingLot parkingLot = new ParkingLot(1);
    assertEquals(new ParkingLot(1), parkingLot);
    assertFalse(parkingLot.isFull());
    parkingLot.park(Vehicle.CAR);
    assertTrue(parkingLot.isFull());
  }

  @Test
  void shouldntBeAbleToParkIfCapacityIsFull() {
    ParkingLot parkingLot = new ParkingLot(0);
    assertTrue(parkingLot.isFull());
    assertThrows(CapacityFullException.class, () -> parkingLot.park(Vehicle.CAR));
  }
}
