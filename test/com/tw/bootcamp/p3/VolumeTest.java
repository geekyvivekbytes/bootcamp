package com.tw.bootcamp.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VolumeTest {
  @Test
  void itShouldCompareLitterToGallon() throws InvalidVolume {
    Volume litter = Volume.createLiter(3.78);
    Volume gallon = Volume.createGallon(1);
   assertEquals(litter,gallon);
  }

  @Test
  void shouldThrowForInvalidVolume() {
    assertThrows(InvalidVolume.class, () -> Volume.createGallon(-34));
  }
}
