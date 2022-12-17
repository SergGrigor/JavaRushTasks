package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Считаем слово
*/

public class Solution {

    private static String afterWord = "\"\\/.,!?:;(){}[]<>'_-";

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(console.readLine());
             BufferedReader reader = new BufferedReader(fileReader)) {
            int countWordWorld = 0;
            StringBuilder stringBuilder = new StringBuilder("");
            while (reader.ready()) {
                String string = reader.readLine();
                stringBuilder.append(string);
                for (int i = 0; i < stringBuilder.length(); i++) {
                    if (afterWord.contains("" + stringBuilder.charAt(i))) {
                        stringBuilder.replace(i , i + 1, " ");
                    }
                }
                string = stringBuilder.toString();
                stringBuilder.delete(0, stringBuilder.length());
                String[] strings = string.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    strings[i].trim();
                    if (strings[i].equals("world")) {
                        countWordWorld++;
                    }
                }
            }
            System.out.println(countWordWorld);
        }
    }
}
