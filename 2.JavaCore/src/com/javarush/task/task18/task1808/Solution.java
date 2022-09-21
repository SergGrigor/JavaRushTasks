package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Arrays;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
             FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
             FileOutputStream fileOutputStream3 = new FileOutputStream(reader.readLine())) {
            if (fileInputStream1.available() > 0) {
                byte [] bytes = new byte[fileInputStream1.available()];
                int count = fileInputStream1.read(bytes);
                if (count % 2 > 0) {
                    fileOutputStream2.write(Arrays.copyOfRange(bytes, 0, bytes.length / 2 + 1));
                    fileOutputStream3.write(Arrays.copyOfRange(bytes, bytes.length / 2 + 1, bytes.length));
                } else {
                    fileOutputStream2.write(Arrays.copyOfRange(bytes, 0, bytes.length / 2));
                    fileOutputStream3.write(Arrays.copyOfRange(bytes, bytes.length / 2, bytes.length));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
