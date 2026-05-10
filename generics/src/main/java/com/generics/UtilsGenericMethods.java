package com.generics;

public class UtilsGenericMethods {

  public static <T> void printItem(T value) {
    System.out.println(value);
  }

  public static <T, K> void printItem(T value, K key) {
    System.out.println(key + " " + value);
  }
}
