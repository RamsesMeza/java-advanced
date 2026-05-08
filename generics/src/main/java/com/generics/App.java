package com.generics;

import com.generics.generic.classes.Box;

public class App {
    public static void main(String[] args) {

        Box<String> box = new Box<>("Pokemon");
        System.out.println(box);

        GenericMethods.printItem("Hola men!");
        GenericMethods.printItem("Galletas", 1);
        GenericMethods.printItem("Galletas", "Ricas");

        System.out.println(GenericRestricted.sum(10, 3));

        // Error becase only accepts Generic type Number
        // System.out.println(GenericRestricted.sum("Hola", 3));
        System.out.println(GenericRestricted.sumSameType(10.1032F, 10));

    }
}
