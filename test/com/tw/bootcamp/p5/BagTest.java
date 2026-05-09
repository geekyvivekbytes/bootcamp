package com.tw.bootcamp.p5;

import com.tw.bootcamp.p4.CapacityFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
  @Test
  void itShouldAddBallToBag() throws CapacityFullException {
    Bag bag = new Bag(12);
    Bag emptyBag = new Bag(12);

    assertEquals(bag, emptyBag);

    bag.add(new Ball());

    assertNotEquals(bag, emptyBag);
  }

  @Test
  void itShouldThrowErrorIfBagIsFull() {
    Bag bag = new Bag(0);
    assertThrows(CapacityFullException.class, () -> bag.add(new Ball()));
  }
}
