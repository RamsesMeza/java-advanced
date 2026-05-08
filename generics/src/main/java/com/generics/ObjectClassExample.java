package com.generics;

import java.util.ArrayList;
import java.util.List;

public class ObjectClassExample {
  public static void main(String[] args) {
    // The Object class is the parent of all clases, so all can be stored in it

    Object name = "Ramses";
    Object number = 49;
    Object array = new ArrayList<>();

    System.out.println(name);
    System.out.println(number);
    System.out.println(array.toString());

    // Cast an array but erro when try to print every element

    List<Object> things = new ArrayList<>();

    things.add("Joel");
    things.add(21);
    things.add(true);

    for (Object object : things) {
      String element = (String) object;
      System.out.println(element.toUpperCase());
    }
  }
}
