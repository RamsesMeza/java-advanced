package com.lambda.exercises.products;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exercises {
  public static void main(String[] args) {
    List<Product> products = List.of(
        new Product("Laptop", "Tecnología", 15000, 5),
        new Product("Mouse", "Tecnología", 300, 20),
        new Product("Teclado", "Tecnología", 800, 0),
        new Product("Silla", "Oficina", 2500, 7),
        new Product("Escritorio", "Oficina", 5000, 2),
        new Product("Café", "Alimentos", 180, 30));

    Map<String, String> categoryReport = products.stream()
        .filter(p -> p.getStock() > 0)
        .collect(
            Collectors.groupingBy(p -> p.getCategory(),
                Collectors.filtering(p -> p.getName() != null,
                    Collectors.mapping(p -> p.getName().toUpperCase(), Collectors.joining(" | ")))

            ));

    categoryReport.forEach((k, v) -> System.out.println(k + " -> " + v));

    Map<String, Double> mapAverage = products.stream()
        .filter(p -> p.getStock() > 0)
        .collect(Collectors.groupingBy(p -> p.getCategory(),
            Collectors.mapping(p -> p.getPrice() * p.getStock(), Collectors.averagingDouble(v -> v))));

    System.out.println(mapAverage);

    // crea un Map<String, List<String>> donde cada categoría tenga los nombres de
    // productos con stock > 0,
    // ordenados alfabéticamente y en mayúsculas.

    Map<String, List<String>> namesSorted = products.stream()
        .filter(p -> p.getStock() > 0)
        .filter(p -> p.getName() != null)
        .sorted(Comparator.comparing(p -> p.getName()))
        .collect(Collectors.groupingBy(p -> p.getCategory(),
            Collectors.mapping(p -> p.getName().toUpperCase(), Collectors.toList())));

    System.out.println(namesSorted);
  }
}
