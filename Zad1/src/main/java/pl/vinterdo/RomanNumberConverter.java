package main.java.pl.vinterdo;

import java.util.SortedMap;
import java.util.TreeMap;

public final class RomanNumberConverter {

    private final static SortedMap<Integer, String> romanDigits = new TreeMap<>(); // need guava to make it immutable
    static {
        romanDigits.put(1000, "M");
        romanDigits.put(900, "CM");
        romanDigits.put(500, "D");
        romanDigits.put(400, "CD");
        romanDigits.put(100, "C");
        romanDigits.put(90, "XC");
        romanDigits.put(50, "L");
        romanDigits.put(40, "XL");
        romanDigits.put(10, "X");
        romanDigits.put(9, "IX");
        romanDigits.put(5, "V");
        romanDigits.put(4, "IV");
        romanDigits.put(1, "I");
    }

    public static String getRoman(int number) {
        if(number <= 0 || number >= 5000) {
            throw new IllegalArgumentException("number " + number + " is not in supported range");
        }
        StringBuilder sb = new StringBuilder();
        SortedMap<Integer, String> currentMap = romanDigits;
        while(number > 0) {
            int curentKey = currentMap.lastKey();
            if(curentKey > number) {
                currentMap = currentMap.headMap(curentKey);
                continue;
            }
            sb.append(currentMap.get(curentKey));
            number -= curentKey;
        }

        return sb.toString();
    }
}

