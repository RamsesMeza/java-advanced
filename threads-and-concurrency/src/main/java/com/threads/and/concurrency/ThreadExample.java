package com.threads.and.concurrency;

public class ThreadExample {

  public static void main(String[] args) {
    Thread worker = new Thread(() -> {
      try {
        System.out.println("Worker sleeping...");
        Thread.sleep(10);
        System.out.println("Worker woke up normally");
      } catch (InterruptedException e) {
        System.out.println("Worker was interrupted while sleeping");
        Thread.currentThread().interrupt();
      }
    });

    worker.start();

    try {
      System.out.println("Thread two running");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Main was interrupted");
      e.printStackTrace();
    }
    worker.interrupt();
  }

}
