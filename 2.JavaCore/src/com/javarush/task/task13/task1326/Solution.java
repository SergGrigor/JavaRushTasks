package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> integers = new ArrayList<>();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(console.readLine());
             BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {
             while (reader.ready()) {
                 int number = Integer.parseInt(reader.readLine());
                 if (number % 2 == 0) {
                     integers.add(number);
                 }
             }
        }
        integers.stream().sorted().forEach(System.out::println);
    }
}
