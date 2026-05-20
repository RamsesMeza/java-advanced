package com.lambda;

public class App {
    public static void main(String[] args) {
        SumarTres tres = (x, y, z) -> x + y + z;
        System.out.println(tres.sumar(1, 2, 3));

    }
}
