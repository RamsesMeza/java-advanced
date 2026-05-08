package com.generics;

public class GenericRestricted {

  public static <T extends Number, K extends Number> double sum(T a, K b) {

    Double result = a.doubleValue() + b.doubleValue();
    return result;
  }

  public static <T extends Number> double sumSameType(T a, T b) {

    Double result = a.doubleValue() + b.doubleValue();
    return result;
  }
}
