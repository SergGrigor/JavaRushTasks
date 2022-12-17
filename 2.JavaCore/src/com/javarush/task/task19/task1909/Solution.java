package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))) {
            StringBuilder stringBuilder = new StringBuilder("");
            while (reader.ready()) {
                String line = reader.readLine();
                stringBuilder.append(line);
                for (int i = 0; i < stringBuilder.length(); i++) {
                    if (stringBuilder.charAt(i) == '.') {
                        stringBuilder.replace(i, i + 1, "!");
                    }
                }
                writer.write(stringBuilder.toString() + System.lineSeparator());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
    }
}
