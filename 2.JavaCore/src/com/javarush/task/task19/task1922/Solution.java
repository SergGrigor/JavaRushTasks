package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            List<String> lines = new ArrayList<>();
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            for (String line: lines) {
                int countOfWords = 0;
                String[] substrings = line.split(" ");
                for (int i = 0; i < substrings.length; i++) {
                    if (words.contains(substrings[i])) {
                        countOfWords++;
                    }
                }
                if (countOfWords == 2) {
                    System.out.println(line);
                }
            }
        }
    }
}
