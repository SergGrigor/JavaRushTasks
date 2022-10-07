package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
        }
        int countSymbols = builder.length();
//        int countSpace = builder.toString().split(" ").length;
        int countSpace = 0;
        for (char aChar: builder.toString().toCharArray()) {
            if (Character.isSpaceChar(aChar)) {
                countSpace++;
            }
        }
        if (countSymbols != 0) {
            System.out.printf("%.2f", (double) countSpace / countSymbols * 100);
        }
    }
}
