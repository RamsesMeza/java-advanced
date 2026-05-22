package com.optional.finalproject.view;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import com.optional.finalproject.model.Product;

public class ProductView {

  private final Scanner scanner;

  public ProductView() {
    this.scanner = new Scanner(System.in);
  }

  public int showMenu() {
    System.out.println(" ");
    System.out.println("---MENU---");
    System.out.println("1. Add new product.");
    System.out.println("2. Search product");
    System.out.println("3. List products");
    System.out.println("4. Show statistics");
    System.out.println("5. Leave");
    return this.askNumber("Select and option: ", Integer::parseInt);
  }

  public int showCategoryMenu() {
    System.out.println(" ");
    System.out.println("---CATEGORIES---");
    System.out.println("1. Electronic");
    System.out.println("2. Clothing");
    System.out.println("3. Food");
    return this.askNumber("Select and option: ", Integer::parseInt);
  }

  public void showErrorMessage(String message) {
    System.out.println(" ");
    System.out.println("Error: " + message);
  }

  public void showMessage(String message) {
    System.out.println(" ");
    System.out.print(message);
  }

  public String askString(String message) {
    System.out.print(message);
    return this.scanner.nextLine();
  }

  public <T extends Number> T askNumber(String message, Function<String, T> parser) {
    while (true) {
      try {
        System.out.print(message);
        return parser.apply(this.scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Must write a number");
      }
    }
  }

  public void listProducts(List<Product> products) {
    System.out.println(" ");
    System.out.println("Productos");

    products.forEach(p -> {
      System.out.println(" ");
      System.out.println("Id: " + p.getId());
      System.out.println("Name: " + p.getName());
      System.out.println("Category: " + p.getCategory());
    });
  }

}
