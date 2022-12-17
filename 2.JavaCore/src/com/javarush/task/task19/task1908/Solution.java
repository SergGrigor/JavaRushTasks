package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(console.readLine());
             FileWriter fileWriter = new FileWriter(console.readLine());
             BufferedReader reader = new BufferedReader(fileReader);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            StringBuilder builder = new StringBuilder("");
            while (reader.ready()) {
                String line = reader.readLine();
                String[] strings = line.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    try (Scanner scanner = new Scanner(strings[i])) {
                        if (scanner.hasNextInt()) {
                            builder.append(scanner.nextInt() + " ");
                        }
                    }
                }

                bufferedWriter.write(builder.toString());
                builder.delete(0, builder.length());
            }
        }
    }
}
