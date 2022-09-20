package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            int countChar = 0;
            while (fileInputStream.available() > 0) {
                if (fileInputStream.read() == 44) {
                    countChar++;
                }
            }
            System.out.println(countChar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
