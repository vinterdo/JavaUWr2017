package main.java.pl.vinterdo;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Arrays.stream(args)
                .map(Integer::new)
                .forEach(x -> System.out.println(x + " " + RomanNumberConverter.getRoman(x)));
    }
}
