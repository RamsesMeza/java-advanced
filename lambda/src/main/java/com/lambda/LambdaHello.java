package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaHello {

  class User {
    private int age;
    private String name;

    public User(int age, String name) {
      this.age = age;
      this.name = name;
    }

  }

  public static void main(String[] args) {

    // List<User> users = new ArrayList<>();
    // users.add(new User(1, "Ramses"));
    // users.add(new User(2, "Joe"));

    Consumer<String> consumidor = name -> System.out.println("Hola " + name);
    consumidor.accept("Joel");

    Predicate<Integer> predicate = age -> age > 18;
    System.out.println(predicate.test(10));

    Predicate<String> esLargo = text -> text.length() > 5;
    System.out.println(esLargo.test("Hola mi nombre es ramses"));

    Function<Integer, Integer> duplicar = n -> n * 2;
    int result = duplicar.apply(10);

    Supplier<Integer> supplier = () -> 9;
    int supplierResult = supplier.get();

    Function<String, Integer> contarCaracteres = (name) -> name.length();

    System.out.println(supplierResult);

  }

  @FunctionalInterface
  interface SayHello {
    void hello(String name);

  }
}
