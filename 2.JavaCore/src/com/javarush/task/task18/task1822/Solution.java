package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int id;
        String productName;
        double price;
        int quantity;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(bufferedReader.readLine());
             BufferedReader reader = new BufferedReader(fileReader)) {
            while (reader.ready()) {
                String string = reader.readLine();
                String[] subStrings = string.split(" ");
                id = Integer.parseInt(subStrings[0]);
                if (id == Integer.parseInt(args[0])) {
                    System.out.println(string);
                }
            }
        }
    }
}
