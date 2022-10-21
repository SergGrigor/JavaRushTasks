package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = console.readLine();
            try (FileInputStream fileIn1 = new FileInputStream(fileName)) {
                byte[] bytes = new byte[fileIn1.available()];
                fileIn1.read(bytes, 0, fileIn1.available());
                try (FileOutputStream fileOut1 = new FileOutputStream(fileName);
                     FileInputStream fileIn2 = new FileInputStream(console.readLine())) {
                    while (fileIn2.available() > 0) {
                        fileOut1.write(fileIn2.read());
                    }
                    fileOut1.write(bytes);
                }
            }
        }
    }
}
