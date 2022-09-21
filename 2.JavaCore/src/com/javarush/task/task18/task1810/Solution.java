package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            while (true) {
                if (fileInputStream.available() < 1000) {
                    fileInputStream.close();
                    throw new DownloadException();
                }
                fileInputStream = new FileInputStream(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class DownloadException extends Exception {

    }
}
