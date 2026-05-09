package com.tw.bootcamp.p5;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bag {

  private final int capacity;
  private final List<Ball> storage;


  public Bag(int capacity) {
    this.capacity = capacity;
    storage = new ArrayList<>();
  }

  public void add(Ball ball) throws LimitExceededException {
    validate(ball);

    storage.add(ball);
  }

  private void validate(Ball ball) throws LimitExceededException {
    if (storage.size() >= capacity) {
      throw new LimitExceededException();
    }


    if (ball.isSameColor(Color.GREEN) && getBallCount(Color.GREEN) == 3) {
      throw new LimitExceededException();
    }

    if (ball.isSameColor(Color.RED) && getBallCount(Color.RED) == getBallCount(Color.GREEN) * 2) {
      throw new LimitExceededException();
    }

  }

  private int getBallCount(Color color) {
    int count = 0;
    for (Ball ball : storage) {
      count += ball.isSameColor(color) ? 1 : 0;
    }
    return count;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Bag bag)) return false;
    return capacity == bag.capacity && Objects.equals(storage, bag.storage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(capacity, storage);
  }
}
