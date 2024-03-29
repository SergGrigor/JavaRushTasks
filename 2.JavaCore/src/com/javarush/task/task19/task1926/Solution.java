package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException  {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader.ready()) {
                StringBuilder builder = new StringBuilder();
                String line = reader.readLine();
                for (int i = line.length() - 1; i >= 0; i--) {
                    builder.append(line.charAt(i));
                }
                System.out.println(builder.toString());
            }
        }
    }
}
