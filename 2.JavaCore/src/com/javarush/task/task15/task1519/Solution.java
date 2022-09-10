package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String number = reader.readLine();
            while (!"exit".equals(number)) {
                try {
                    if (number.contains(".")) {
                        print(Double.parseDouble(number));
                        number = reader.readLine();
                        continue;
                    }
                    if (Integer.parseInt(number) > 0 && Integer.parseInt(number) < 128) {
                        print(Short.parseShort(number));
                        number = reader.readLine();
                        continue;
                    }
                    if (Integer.parseInt(number) <= 0 || Integer.parseInt(number) >= 128) {
                        print(Integer.parseInt(number));
                        number = reader.readLine();
                        continue;
                    }
                } catch (Exception e) {
                    print(number);
                    number = reader.readLine();
                    continue;
                }

            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
