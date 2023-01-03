package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter writer = new FileWriter(args[1])) {
            StringBuilder builder = new StringBuilder();
            List<String> lines = new ArrayList<>();
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            for (int i = 0; i < lines.size(); i++) {
                String[] strings = lines.get(i).split(" ");
                for (int j = 0; j < strings.length; j++) {
                    if (strings[j].length() > 6) {
                        builder.append(strings[j] + ",");
                    }
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            writer.write(builder.toString());
        }
    }
}
