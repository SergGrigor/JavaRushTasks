package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        String punctuation = ".,!?";
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader.ready()) {
                StringBuffer string = new StringBuffer();
                String[] substrings = reader.readLine().split(" ");
                for (int i = 0; i < substrings.length; i++) {
                    String endSymbol = substrings[i].charAt(substrings[i].length() - 1) + "";
                    if (punctuation.contains(endSymbol)) {
                        substrings[i] = substrings[i].substring(0 , substrings[i].length() - 1);
                        try {
                            int number = Integer.parseInt(substrings[i]);
                            if (map.containsKey(number)) {
                                string.append(map.get(number) + endSymbol +  " ");
                            } else {
                                string.append(substrings[i] + endSymbol + " ");
                            }
                        } catch (Exception e) {
                            string.append(substrings[i] + endSymbol + " ");
                        }
                    } else {
                        try {
                            int number = Integer.parseInt(substrings[i]);
                            if (map.containsKey(number)) {
                                string.append(map.get(number) + " ");
                            } else {
                                string.append(substrings[i] + " ");
                            }
                        } catch (Exception e) {
                            string.append(substrings[i] + " ");
                        }
                    }
                }
                System.out.println(string.toString().trim());
            }
        }
    }
}
