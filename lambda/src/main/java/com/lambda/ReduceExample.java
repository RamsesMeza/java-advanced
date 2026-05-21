package com.lambda;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReduceExample {

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  static class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
  }

  public static void main(String[] args) {
    List<Producto> productos = List.of(
        new Producto("Laptop", "Tecnología", 15000, 5),
        new Producto("Mouse", "Tecnología", 300, 20),
        new Producto("Teclado", "Tecnología", 800, 0),
        new Producto("Silla", "Oficina", 2500, 7),
        new Producto("Escritorio", "Oficina", 5000, 2),
        new Producto("Café", "Alimentos", 180, 30));

    Double total = productos.stream().map(p -> p.getPrecio() * p.getStock()).reduce(0.0, (acc, t) -> acc + t);
    // System.out.println(total);

    productos.stream().filter(p -> p.getStock() > 0).map(p -> p.getNombre());

    List<Double> preciosTecnologia = productos.stream().filter(p -> p.getCategoria().equals("Tecnología"))
        .map(p -> p.getPrecio()).toList();

    Double totalPrice = productos.stream().filter(p -> p.getCategoria().equals("Tecnología"))
        .map(p -> p.getPrecio()).reduce(0.0, (acc, price) -> acc + price);

    // System.out.println(totalPrice);

    Double totalPriceTecnology = productos.stream().filter(p -> "Tecnología".equals(p.getCategoria()))
        .mapToDouble(p -> p.getPrecio() * p.getStock()).sum();

    Map<String, Double> mapCategory = productos.stream()
        .collect(
            Collectors.groupingBy(p -> p.getCategoria(),
                Collectors.summingDouble(p -> p.getPrecio() * p.getStock())));

    System.out.println(mapCategory);

    Map<String, Long> counterMap = productos.stream()
        .collect(
            Collectors.groupingBy(p -> p.getCategoria(), Collectors.counting()));

    System.out.println(counterMap);

    Map<String, Double> productPrices = productos.stream().collect(Collectors.groupingBy(p -> p.getCategoria(),
        Collectors.summingDouble(p -> p.getPrecio())));

    Map<String, Long> counterProductsByCategory = productos.stream()
        .filter(p -> p.getStock() > 0)
        .collect(Collectors.groupingBy(p -> p.getCategoria(), Collectors.counting()));

    Map<String, List<String>> nameOfTheProductsByCategory = productos.stream()
        .filter(p -> p.getStock() > 0)
        .collect(
            Collectors.groupingBy(p -> p.getCategoria(), Collectors.mapping(p -> p.getNombre(), Collectors.toList())));

    Map<String, String> nameOfTheProductsByCategory2 = productos.stream()
        .filter(p -> p.getStock() > 0)
        .collect(
            Collectors.groupingBy(p -> p.getCategoria(),
                Collectors.mapping(p -> p.getNombre(), Collectors.joining(", "))));

    Map<String, Double> AverageByCategory = productos.stream()
        .filter(p -> p.getStock() > 0)
        .collect(
            Collectors.groupingBy(p -> p.getCategoria(),
                Collectors.averagingDouble(p -> p.getPrecio())));

    Map<String, Optional<Producto>> maxByCategory = productos.stream()
        .filter(p -> p.getStock() > 0)
        .collect(
            Collectors.groupingBy(p -> p.getCategoria(),
                Collectors.maxBy(Comparator.comparing(p -> p.getPrecio()))));

    Map<String, Optional<Producto>> minByCategory = productos.stream()
        .filter(p -> p.getStock() > 0)
        .collect(
            Collectors.groupingBy(p -> p.getCategoria(),
                Collectors.minBy(Comparator.comparing(p -> p.getPrecio()))));

    // minByCategory.forEach((k, v) -> {
    // v.ifPresent(p -> System.out.println(k + ": " + p.getNombre()));
    // });

    Map<String, Long> counterMoreThan500 = productos.stream().filter(p -> p.getPrecio() > 500).collect(
        Collectors.groupingBy(p -> p.getCategoria(),
            Collectors.counting()));

    System.out.println("Mayor a 500");
    counterMoreThan500.forEach((k, v) -> System.out.println(k + ": " + v));

    Map<String, Boolean> productWithoutStock = productos.stream().collect(
        Collectors.groupingBy(p -> p.getCategoria(),
            Collectors.reducing(
                true,
                (p) -> p.getStock() > 0,
                (acc, v) -> acc && v)));

    System.out.println("Sin stock");
    System.out.println(productWithoutStock);

    System.out.println("anyMatch, allMatch, noneMatch");
    productos.stream().allMatch(p -> p.getPrecio() > 100);
    productos.stream().noneMatch(p -> p.getStock() < 0);

    // Obtén una List<String> con los nombres en mayúsculas de productos que tengan
    // stock > 0 y precio > 500.

    List<String> listResult = productos.stream()
        .filter(p -> p.getStock() > 0 && p.getPrecio() > 500 && p.getNombre() != null)
        .map(p -> p.getNombre().toUpperCase()).toList();

    System.out.println("Ejercicio compuesto");
    System.out.println(listResult);

    // List<String> names = productos.stream().filter(p -> p.stock > 0).filter(p ->
    // p.precio > 500)
    // .map(p -> p.nombre.toUpperCase()).toList();

    // Map<String, List<Producto>> porCategoria = productos.stream()
    // .collect(Collectors.groupingBy(p -> p.categoria));

    // // names.forEach(System.out::println);

    // porCategoria.forEach((k, v) -> System.out.println(k + " " + v.stream().map(e
    // -> e.nombre).toList()));

    // Collectors.mapping(null, null);
  }
}
