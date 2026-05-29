package com.threads.and.concurrency.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
  public static void main(String[] args) {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      return "Java";
    });

    future
        .thenApply(result -> result.toUpperCase())
        .thenAccept(result -> {
          System.out.println(result);
        });
  }
}
