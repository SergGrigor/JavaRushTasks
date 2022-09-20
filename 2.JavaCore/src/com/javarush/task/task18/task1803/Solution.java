package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            List <Integer> bytes = new ArrayList<Integer>();
            List <Integer> bytesRepeatMax = new ArrayList<Integer>();
            int max = 0;
            int frequencyByteMax = 0;
            while (fileInputStream.available() > 0) {
                bytes.add(fileInputStream.read());
            }
            for (int i = 0; i < 256; i++) {
                if (Collections.frequency(bytes, i) > frequencyByteMax) {
                    frequencyByteMax = Collections.frequency(bytes, i);
                    max = i;
                }
            }
            for (int i = 0; i < 256; i++) {
                if (Collections.frequency(bytes, i) == frequencyByteMax) {
                    bytesRepeatMax.add(i);
                }
            }
            for (Integer repeatMax : bytesRepeatMax) {
                System.out.print(repeatMax + " ");
            }
        }
    }
}
