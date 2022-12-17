package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {

    private static String punctuation = "~@#$%^&*+|=.,?!:;_ \uE00D\uE00A\\\"'-/<>(){}[]—–";

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))) {
            while (reader.ready()) {
                writer.write(reader.readLine().replaceAll("\\p{P}", ""));
            }
        }
    }
}
