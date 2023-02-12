package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(args[0]);
             FileOutputStream outputStream = new FileOutputStream(args[1])) {
            byte[] bytes = new byte[1000];
            inputStream.read(bytes);
            String string = new String(bytes, "Windows-1251");
            bytes = string.getBytes(StandardCharsets.UTF_8);
            outputStream.write(bytes);
        }
    }
}
