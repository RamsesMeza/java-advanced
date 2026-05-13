package com.generics;

public class App {
    public static void main(String[] args) {

        Box<String> box = new Box<>("Pokemon");
        System.out.println(box);

        UtilsGenericMethods.printItem("Hola men!");
        UtilsGenericMethods.printItem("Galletas", 1);
        UtilsGenericMethods.printItem("Galletas", "Ricas");

        System.out.println(GenericRestricted.sum(10, 3));

        // Error becase only accepts Generic type Number
        // System.out.println(GenericRestricted.sum("Hola", 3));
        System.out.println(GenericRestricted.sumSameType(10.1032F, 10));

    }
}
