package com.javarush.task.pro.task15.task1521;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Временное сохранение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //напишите тут ваш код
        URL url = new URL("https://ru.wikipedia.org/wiki/%D0%9B%D0%B0-%D0%A2%D0%BE%D1%80%D1%82%D1%83%D0%B3%D0%B0");
        InputStream inputStream = url.openStream();
        byte[] buffer = inputStream.readAllBytes();
        Files.write(Files.createTempFile(null, null), buffer);
    }
}