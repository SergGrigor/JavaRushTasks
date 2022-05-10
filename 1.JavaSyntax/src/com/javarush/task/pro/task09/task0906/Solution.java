package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        //                            2_147_483_647
        //1_111_111_111_111_111_111_111_111_111_111
        //                              2^2+2^1+2^0
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        if (decimalNumber <= 0) {
            return "";
        }
        String binaryNumber = "";
        while (decimalNumber != 0) {
            binaryNumber = decimalNumber % 2 + binaryNumber;
            decimalNumber = decimalNumber / 2;
        }
        return binaryNumber;
    }

    public static int toDecimal(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.equals("")) {
            return 0;
        }
        int decimalNumber = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            char charAt = binaryNumber.charAt(binaryNumber.length() - 1 - i);
            int numericValue = Character.getNumericValue(charAt);
            decimalNumber = decimalNumber + numericValue * (int) Math.pow(2, i);
        }
        return decimalNumber;
    }
}
