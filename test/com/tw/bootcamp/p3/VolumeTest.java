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
  void itShouldAddTwoVolumeAndReturnInLiter() throws InvalidVolume {
    Volume oneLiter = Volume.createLiter(1);
    Volume gallon = Volume.createGallon(1);
    assertEquals(Volume.createLiter(4.78),gallon.add(oneLiter));
  }

  @Test
  void shouldThrowForInvalidVolume() {
    assertThrows(InvalidVolume.class, () -> Volume.createGallon(-34));
  }
}
