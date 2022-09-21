package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine());
             FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine())) {
            if (fileInputStream.available() > 0) {
                byte[] bytes = new byte[fileInputStream.available()];
                int countBytes = fileInputStream.read(bytes);
                byte[] bytesReverse = new byte[countBytes];
                for (int i = 0; i < bytes.length; i++) {
                    bytesReverse[i] = bytes[bytes.length - 1 - i];
                }
                fileOutputStream.write(bytesReverse);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
