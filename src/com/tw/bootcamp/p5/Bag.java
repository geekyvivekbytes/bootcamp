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
    int currentSize = storage.size();

    if (currentSize >= capacity) {
      throw new LimitExceededException();
    }

    if (ball.isSameColor(Color.GREEN) && getBallCountOf(Color.GREEN) == 3) {
      throw new LimitExceededException();
    }

    if (ball.isSameColor(Color.RED) && getBallCountOf(Color.RED) == getBallCountOf(Color.GREEN) * 2) {
      throw new LimitExceededException();
    }

    int yellowCount = getBallCountOf(Color.YELLOW);
    double expectedYellowCount = currentSize * 0.4;

    if (ball.isSameColor(Color.YELLOW) && expectedYellowCount - yellowCount < 1) {
      throw new LimitExceededException();
    }

  }

  private int getBallCountOf(Color color) {
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


  public String generateSummary() {
    StringBuilder stringBuilder = new StringBuilder();

    for (Color color : Color.values()) {
      int count = getBallCountOf(color);
      if (count != 0) {
        stringBuilder
                .append(color.toString().toLowerCase())
                .append(" :")
                .append(count)
                .append("\n");
      }
    }
    stringBuilder.append("\nTotal :").append(storage.size());

    return stringBuilder.toString();
  }
}
