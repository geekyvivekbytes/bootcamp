package com.tw.bootcamp.p5;

import com.tw.bootcamp.p4.CapacityFullException;

import java.util.ArrayList;
import java.util.Objects;

public class Bag {

  private final int capacity;
  private final ArrayList<Ball> storage;

  public Bag(int capacity) {
    this.capacity = capacity;
    storage = new ArrayList<>();
  }

  public void add(Ball ball) throws CapacityFullException {
    if (storage.size() >= capacity) {
      throw new CapacityFullException();
    }
    storage.add(ball);
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
