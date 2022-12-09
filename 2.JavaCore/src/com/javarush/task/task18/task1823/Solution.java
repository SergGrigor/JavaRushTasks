package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = reader.readLine();
            while (!string.equals("exit")) {
                ReadThread readThread = new ReadThread(string);
                readThread.start();
                readThread.join();
                string = reader.readLine();
            }
        }
    }

    public static class ReadThread extends Thread {

        private String nameFile;
        public ReadThread(String fileName) {
            nameFile = fileName;
        }

        @Override
        public void run() {
            int[] bytes = new int[256];
            try (FileInputStream fileInputStream = new FileInputStream(nameFile)) {
                while (fileInputStream.available() > 0) {
                    bytes [fileInputStream.read()]++;
                }
                resultMap.put(nameFile, maxByte(bytes));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private Integer maxByte (int[] bytes) {
            Integer maxByte = 0;
            int numberOfByte = 0;
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > numberOfByte) {
                    maxByte = i;
                    numberOfByte = bytes[i];
                }
            }
            return maxByte;
        }
    }
}
