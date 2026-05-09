package com.tw.bootcamp.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ParkingAssistantTest {
  @Test
  void assistantShouldTellIfLotIsFull() {
    ParkingSystemView parkingSystem = mock(ParkingSystem.class);
    Assistant assistant = new Assistant(parkingSystem);
    when(parkingSystem.isLotFull("P1")).thenReturn(true);

    assertTrue(assistant.isLotFull("P1"));
  }

  @Test
  void assistantShouldHaveParkingSystemReport() {
    ParkingSystemView parkingSystem = mock(ParkingSystem.class);
    Assistant assistant = new Assistant(parkingSystem);
    when(parkingSystem.report()).thenReturn("P1 Full (6/6)");

    String report = assistant.displayReport();

    assertEquals("P1 Full (6/6)", report);
    verify(parkingSystem).report();
  }
}
