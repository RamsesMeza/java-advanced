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
    System.out.println("1. Add new product");
    System.out.println("2. Search product");
    System.out.println("3. List products");
    System.out.println("4. Show statistics");
    System.out.println("5. Leave");
    return this.askNumber("Select and option: ", Integer::parseInt);
  }

  public int showFindProductMenu() {

    while (true) {
      try {
        System.out.println(" ");
        System.out.println("Search by:");
        System.out.println("1. Name");
        System.out.println("2. Id");

        int option = this.askNumber("Select and option: ", Integer::parseInt);

        boolean invalidRange = option <= 0 || option > 2;

        if (invalidRange) {
          throw new Exception("Select a valid option");
        }

        return option;
      } catch (Exception e) {
        this.showErrorMessage(e.getMessage());
      }
    }

  }

  public void printProduct(Product product) {
    System.out.println(" ");
    System.out.println("Id: " + product.getId());
    System.out.println("Name: " + product.getName());
    System.out.println("Category: " + product.getCategory());
  }

  public int showCategoryMenu() {

    while (true) {
      try {
        System.out.println(" ");
        System.out.println("---CATEGORIES---");
        System.out.println("1. Electronic");
        System.out.println("2. Clothing");
        System.out.println("3. Food");

        int option = this.askNumber("Select and option: ", Integer::parseInt);

        boolean invalidRange = option <= 0 || option > 3;

        if (invalidRange) {
          throw new Exception("Select a valid option");
        }

        return option;
      } catch (Exception e) {
        this.showErrorMessage(e.getMessage());
      }
    }

  }

  public int showListProductsMenu() {

    while (true) {
      try {
        System.out.println(" ");
        System.out.println("---Filters---");
        System.out.println("1. Category");
        System.out.println("2. Price more then");
        System.out.println("3. Food");

        int option = this.askNumber("Select and option: ", Integer::parseInt);

        boolean invalidRange = option <= 0 || option > 3;

        if (invalidRange) {
          throw new Exception("Select a valid option");
        }

        return option;
      } catch (Exception e) {
        this.showErrorMessage(e.getMessage());
      }
    }

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

    System.out.println(products);

    products.forEach(p -> {
      System.out.println(" ");
      System.out.println("Id: " + p.getId());
      System.out.println("Name: " + p.getName());
      System.out.println("Category: " + p.getCategory());
    });
  }

}
