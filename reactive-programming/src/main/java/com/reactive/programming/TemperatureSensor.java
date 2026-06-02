package com.reactive.programming;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class TemperatureSensor {
  public static void main(String[] args) {

    Observable<Long> stream = Observable.interval(1, TimeUnit.SECONDS);

    Observable<Double> temperatureObservable = stream.map(
        (unit) -> {
          double randomTemperature = 20 + Math.random() * 15;
          System.out.println("Temperatura actual: " + randomTemperature);
          return randomTemperature;
        });

    temperatureObservable
        .filter(tem -> tem > 30)
        .subscribe(
            item -> System.out.println("Temperatura Alta"),
            error -> System.out.println("Error:" + error.getMessage()),
            () -> System.out.println("Fin"));

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
