package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            Set<Integer> bytes = new TreeSet<>();
            while (fileInputStream.available() > 0) {
                bytes.add(fileInputStream.read());
            }
            bytes.stream().sorted().forEach(byteCode -> System.out.print(byteCode + " "));
        }
    }
}
