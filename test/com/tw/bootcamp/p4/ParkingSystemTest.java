package com.tw.bootcamp.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ParkingSystemTest {
  @Test
  void itShouldHandleSingleParkingLot() throws CapacityFullException {
    ParkingSystem parkingSystem = new ParkingSystem();
    ParkingLot parkingLot = mock(ParkingLot.class);
    Car car = mock(Car.class);

    parkingSystem.add("P1", parkingLot);
    parkingSystem.park("P1", car);

    verify(parkingLot).park(car);
    verifyNoMoreInteractions(parkingLot);
  }

  @Test
  void itShouldHandleMultipleParkingLot() throws CapacityFullException {
    ParkingSystem parkingSystem = new ParkingSystem();
    ParkingLot parkingLot1 = mock(ParkingLot.class);
    ParkingLot parkingLot2 = mock(ParkingLot.class);
    Car car = mock(Car.class);

    parkingSystem.add("P1", parkingLot1);
    parkingSystem.add("P2", parkingLot2);
    parkingSystem.park("P2", car);

    verify(parkingLot2).park(car);
    verifyNoInteractions(parkingLot1);
    verifyNoMoreInteractions(parkingLot2);
  }

  @Test
  void itShouldReturnWhetherParkingIsFull() {
    ParkingSystem parkingSystem = new ParkingSystem();
    ParkingLot parkingLot = mock(ParkingLot.class);
    when(parkingLot.isFull()).thenReturn(true);

    parkingSystem.add("P1", parkingLot);

    assertTrue(parkingSystem.isLotFull("P1"));
  }
}
