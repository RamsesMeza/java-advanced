package com.optional.finalproject.view;

import java.util.Scanner;
import java.util.function.Function;

public class ProductView {

  private final Scanner scanner;

  public ProductView() {
    this.scanner = new Scanner(System.in);
  }

  public int showMenu() {
    System.out.println("---MENU---");
    System.out.println("1. Add new product.");
    System.out.println("2. Search product");
    System.out.println("3. List products");
    System.out.println("4. Show statistics");
    System.out.println("5. Leave");
    return this.askNumber("Select and option: ", (s) -> Integer.parseInt(s));
  }

  public void showErrorMessage(String message) {
    System.out.println("Error: " + message);
  }

  public void showMessage(String message) {
    System.out.println(message);
  }

  public String askString(String message) {
    System.out.println(message);
    return this.scanner.nextLine();
  }

  public <T extends Number> T askNumber(String message, Function<String, T> parser) {
    while (true) {
      try {
        System.out.println(message);
        return parser.apply(this.scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Must write a number");
      }
    }
  }

}
