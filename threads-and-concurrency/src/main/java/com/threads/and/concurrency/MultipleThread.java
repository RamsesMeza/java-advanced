package com.threads.and.concurrency;

public class MultipleThread {
  public static void main(String[] args) {

    Counter counter = new Counter();

    Runnable task = () -> {
      counter.increment();
      System.out.println(counter.getCount());
    };

    Runnable task2 = () -> {
      counter.increment();
      System.out.println(counter.getCount());
    };

    Thread t1 = new Thread(task);
    Thread t2 = new Thread(task2);

    t1.start();
    t2.start();
  }
}
