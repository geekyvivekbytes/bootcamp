package com.tw.bootcamp.p5;

import org.junit.jupiter.api.Test;

import javax.naming.LimitExceededException;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
  @Test
  void itShouldAddBallToBag() throws LimitExceededException {
    Bag bag = new Bag(12);
    Bag emptyBag = new Bag(12);

    assertEquals(bag, emptyBag);

    bag.add(new Ball(Color.GREEN));

    assertNotEquals(bag, emptyBag);
  }

  @Test
  void itShouldNotAllowMoreThatThreeBall() throws LimitExceededException {
    Bag bag = new Bag(12);
    bag.add(new Ball(Color.GREEN));
    bag.add(new Ball(Color.GREEN));
    bag.add(new Ball(Color.GREEN));

    assertThrows(LimitExceededException.class, () -> bag.add(new Ball(Color.GREEN)));
  }

  @Test
  void itShouldThrowIfRedBallsAreMoreThanDoubleGreenBalls() throws LimitExceededException {
    Bag bag = new Bag(12);
    bag.add(new Ball(Color.GREEN));
    bag.add(new Ball(Color.RED));
    bag.add(new Ball(Color.RED));

    assertThrows(LimitExceededException.class, () -> bag.add(new Ball(Color.RED)));
  }

  @Test
  void itShouldThrowErrorIfBagIsFull() {
    Bag bag = new Bag(0);
    assertThrows(LimitExceededException.class, () -> bag.add(new Ball(Color.BLUE)));
  }
}