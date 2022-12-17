package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(console.readLine());
             FileWriter fileWriter = new FileWriter(console.readLine()))  {
            for (int i = 1; fileReader.ready(); i++) {
                if ((i % 2) != 0) {
                    fileReader.read();
                } else {
                    fileWriter.write(fileReader.read());
                }
            }
        }
    }
}
