package com.reactive.programming;

import java.util.Scanner;

import io.reactivex.rxjava3.subjects.PublishSubject;

public class ReactiveScanner {

  public static void main(String[] args) {
    PublishSubject<String> inputStream = PublishSubject.create();

    inputStream.subscribe(
        (item) -> System.out.println("Recibido: " + item.toUpperCase()),
        error -> System.out.println(error.getMessage()),
        () -> System.out.println("Finalizado"));

    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingresa un texto p \"salir\" para terminar la app");

    while (true) {

      String text = scanner.nextLine();

      if ("salir".equalsIgnoreCase(text)) {
        inputStream.onComplete();
        break;
      }

      inputStream.onNext(text);
    }

    scanner.close();
  }
}
