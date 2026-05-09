package com.tw.bootcamp.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
  @Test
  void parkShouldParkTheGivenCar() throws CapacityFullException {
    ParkingLot parkingLot = ParkingLot.create(1);
    assertEquals(ParkingLot.create(1), parkingLot);
    assertFalse(parkingLot.isFull());
    parkingLot.park(new Car(12));
    assertTrue(parkingLot.isFull());
  }

  @Test
  void shouldntBeAbleToParkIfCapacityIsFull() {
    ParkingLot parkingLot = ParkingLot.create(0);
    assertTrue(parkingLot.isFull());
    assertThrows(CapacityFullException.class, () -> parkingLot.park(new Car(12)));
  }

  @Test
  void shouldThrowExceptionIfCapacityIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> ParkingLot.create(-34));
  }
}
