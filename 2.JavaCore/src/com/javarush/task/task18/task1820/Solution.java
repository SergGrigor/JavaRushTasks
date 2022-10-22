package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
             FileWriter fileOutput = new FileWriter(console.readLine())) {
            while (reader.ready()) {
                String [] numbers = reader.readLine().split(" ");
                for (String number : numbers) {
                    double numb = Double.parseDouble(number);
                    long roundNumber = Math.round(numb);
                    fileOutput.write(roundNumber + " ");
                }
            }
        }
    }
}
