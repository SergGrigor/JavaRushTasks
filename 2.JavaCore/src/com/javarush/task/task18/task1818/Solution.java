package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fileOut1 = new FileOutputStream(console.readLine(),true);
             FileInputStream fileIn2  = new FileInputStream(console.readLine());
             FileInputStream fileIn3  = new FileInputStream(console.readLine())) {
            while (fileIn2.available() > 0) {
                fileOut1.write(fileIn2.read());
            }
            while (fileIn3.available() > 0) {
                fileOut1.write(fileIn3.read());
            }
        }
    }
}
