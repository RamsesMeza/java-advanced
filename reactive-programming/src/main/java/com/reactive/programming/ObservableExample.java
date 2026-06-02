package com.reactive.programming;

import io.reactivex.rxjava3.core.Observable;

public class ObservableExample {
  public static void main(String[] args) {
    Observable<String> courseStream = Observable.just("HTML", "JAVA", "CSS", "C");

    courseStream.subscribe(
        item -> System.out.println("Recibido: " + item),
        error -> System.out.println("Error: " + error.getMessage()),
        () -> System.out.println("Terminado"));
  }
}
