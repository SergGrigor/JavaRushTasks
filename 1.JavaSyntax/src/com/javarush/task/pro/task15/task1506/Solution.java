package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);) {
            List<String> list = Files.readAllLines(Paths.get(scanner.nextLine()));
            String string = "";
            for (int i = 0; i < list.size(); i++) {
                StringBuilder stringBuilder = new StringBuilder(list.get(i));
                for (int j = 0; j < stringBuilder.length(); j++) {
                    if (stringBuilder.charAt(j) == '.' || stringBuilder.charAt(j) == ' ' || stringBuilder.charAt(j) == ',') {
                        stringBuilder.deleteCharAt(j);
                        j--;
                    }
                }
                string = string + stringBuilder.toString();
            }

            System.out.println(string);
        }
    }
}

