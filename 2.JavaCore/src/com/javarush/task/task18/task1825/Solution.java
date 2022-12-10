package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<String> namesFiles = new ArrayList<>();
            String string = reader.readLine();
            while (!string.equals("end")) {
                namesFiles.add(string);
                string = reader.readLine();
            }
            Collections.sort(namesFiles, Comparator.comparingInt((String o) -> Integer.parseInt(o.substring(o.length() - 1)))
            );
            String fileName = namesFiles.get(0).substring(0, namesFiles.get(0).indexOf(".part"));
            try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileName))) {
                for (int i = 0; i < namesFiles.size(); i++) {
                    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(namesFiles.get(i)))) {
                        while (bufferedInputStream.available() > 0) {
                            writer.write(bufferedInputStream.read());
                        }
                    }
                }
            }

        }
    }
}
