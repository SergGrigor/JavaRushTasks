package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(System.in);
             InputStream inputFile = Files.newInputStream(Paths.get(scanner.nextLine()));
             OutputStream outputFile = Files.newOutputStream(Paths.get(scanner.nextLine()))) {
            byte[] bytes = inputFile.readAllBytes();
            if ((bytes.length % 2) == 0) {
                for (int i = 0; i < bytes.length; i += 2) {
                    outputFile.write(bytes[i + 1]);
                    outputFile.write(bytes[i]);
                }
            } else {
                for (int i = 0; i < bytes.length; i += 2) {
                    if (i == (bytes.length - 1)) {
                        outputFile.write(bytes[i]);
                    } else {
                        outputFile.write(bytes[i + 1]);
                        outputFile.write(bytes[i]);
                    }
                }
            }
        }

    }
}

