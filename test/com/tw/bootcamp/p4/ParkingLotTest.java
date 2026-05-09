package com.tw.bootcamp.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
  @Test
  void parkShouldParkTheGivenCar() throws CapacityFullException {
    ParkingLot parkingLot = ParkingLot.create("P1", 1);
    assertEquals(ParkingLot.create("P1", 1), parkingLot);
    assertFalse(parkingLot.isFull());
    parkingLot.park(new Car(12));
    assertTrue(parkingLot.isFull());
  }

  @Test
  void shouldntBeAbleToParkIfCapacityIsFull() {
    ParkingLot parkingLot = ParkingLot.create("P1", 0);
    assertTrue(parkingLot.isFull());
    assertThrows(CapacityFullException.class, () -> parkingLot.park(new Car(12)));
  }

  @Test
  void shouldThrowExceptionIfCapacityIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> ParkingLot.create("P1", -34));
  }

  @Test
  void toStringShouldReturnItsBasicInfo() throws CapacityFullException {
    ParkingLot parkingLot = ParkingLot.create("P1", 1);

    assertEquals("P1 Free 0/1", parkingLot.toString());

    parkingLot.park(new Car(12));
    assertEquals("P1 Full 1/1", parkingLot.toString());
  }
}
