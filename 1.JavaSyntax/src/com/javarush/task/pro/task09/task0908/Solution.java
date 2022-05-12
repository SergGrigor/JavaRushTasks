package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    private static final String[] HEX = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private static final String[] BINARY_HEX = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                                                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        String binaryNumb = "";
        if (binaryNumber == null || binaryNumber.equals("")) {
            return "";
        } else {
            // поиск символов кроме 0 и 1
            for (int i = 0; i < binaryNumber.length(); i++) {
                char charBinNumber = binaryNumber.charAt(i);
                if ((charBinNumber != '0' & charBinNumber != '1')) {
                    return "";
                }
            }
            // добавление 0-ей в начало строки, если не хватает
            if ((binaryNumber.length() % 4) > 0) {
                for (int i = 0; i < (binaryNumber.length() % 4); i++) {
                    binaryNumber = "0" + binaryNumber;
                }
            }
            // проверка группы символов на соответсвие с шестнадцатеричной кодировкой
            for (int i = 0; i < binaryNumber.length(); i += 4) {
                String binHex = "";
                for (int j = i + 0; j < (4 + i); j++) {
                    binHex = binHex + binaryNumber.charAt(j);
                }
                for (int j = 0; j < BINARY_HEX.length; j++) {
                    if (binHex.equals(BINARY_HEX[j])) {
                        binaryNumb = binaryNumb + HEX[j];
                        break;
                    }
                }
            }
            return binaryNumb;
        }
    }

    public static String toBinary(String hexNumber) {
        String binNumb = "";
        if (hexNumber == null || hexNumber.equals("")) {
            return "";
        } else {
            // поиск символов кроме 0-9 и a-f в нижнем регистре
            for (int i = 0; i < hexNumber.length(); i++) {
                boolean noEqualHex = true;
                for (int j = 0; j < HEX.length; j++) {
                    String hex = HEX[j].charAt(0) + "";
                    String hexN = hexNumber.charAt(i) + "";
                    if (hexN.equals(hex)) {
                        noEqualHex = false;
                    } else {
                        continue;
                    }
                }
                if (noEqualHex) {
                    return "";
                }
            }
            // перевод из шестнадцатиричной в двоичную
            for (int i = 0; i < hexNumber.length(); i++) {
                String bin = "";
                for (int j = 0; j < HEX.length; j++) {
                    char hexNumb = hexNumber.charAt(i);
                    char hex = HEX[j].charAt(0);
                    if (hexNumb == hex) {
                        bin = bin + BINARY_HEX[j];
                        break;
                    }
                }
                binNumb = binNumb + bin;
            }
            return binNumb;
        }
    }
}
