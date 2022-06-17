package com.javarush.task.pro.task15.task1522;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
    }
}