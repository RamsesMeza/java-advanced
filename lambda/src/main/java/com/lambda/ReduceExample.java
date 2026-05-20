package com.lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    List<String> names = productos.stream().filter(p -> p.stock > 0).filter(p -> p.precio > 500)
        .map(p -> p.nombre.toUpperCase()).toList();

    Map<String, List<Producto>> porCategoria = productos.stream()
        .collect(Collectors.groupingBy(p -> p.categoria));

    // names.forEach(System.out::println);

    porCategoria.forEach((k, v) -> System.out.println(k + " " + v.stream().map(e -> e.nombre).toList()));

    Collectors.mapping(null, null);
  }
}
