package com.threads.and.concurrency.ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
  public static void main(String[] args) {

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    scheduler.schedule(() -> {
      System.out.println("Runs after 2 seconds");
    }, 12, TimeUnit.SECONDS);

    scheduler.scheduleAtFixedRate(() -> {
      System.out.println("Rate");
    }, 1, 3, TimeUnit.SECONDS);

    scheduler.scheduleWithFixedDelay(() -> {
      System.out.println("Delay");
    }, 3, 6, TimeUnit.SECONDS);
  }
}
