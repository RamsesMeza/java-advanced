package com.reactive.programming;

import java.util.NoSuchElementException;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

public class OnSubscribeExample {
  public static void main(String[] args) {

    ObservableOnSubscribe<String> subcribe = new ObservableOnSubscribe<>() {

      @Override
      public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {

        emitter.onNext("Ramses");
        emitter.onNext("Joel");
        emitter.onNext("Les");

      }

    };

    // e -> {

    // e.onNext("Ramses");
    // e.onNext("Joel");
    // e.onNext("Les");

    // e.onError(new NoSuchElementException("Error no encontrado"));

    // }
    Observable<String> stream = Observable.create(subcribe);

    stream.subscribe(
        i -> System.out.println(i),
        e -> System.out.println(e.getMessage()),
        () -> System.out.println("Process ended"));
  }
}