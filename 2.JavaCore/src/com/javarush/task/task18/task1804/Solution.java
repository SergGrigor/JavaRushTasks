package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            List<Integer> bytes = new ArrayList<Integer>();
            List <Integer> bytesRepeatMin = new ArrayList<Integer>();
            int frequencyByteMin = Integer.MAX_VALUE;
            while (fileInputStream.available() > 0) {
                bytes.add(fileInputStream.read());
            }
            for (int i = 0; i < 256; i++) {
                if (Collections.frequency(bytes, i) < frequencyByteMin && Collections.frequency(bytes, i) > 0) {
                    frequencyByteMin = Collections.frequency(bytes, i);
                }
            }
            for (int i = 0; i < 256; i++) {
                if (Collections.frequency(bytes, i) == frequencyByteMin) {
                    bytesRepeatMin.add(i);
                }
            }
            for (Integer repeatMin : bytesRepeatMin) {
                System.out.print(repeatMin + " ");
            }
        }

    }
}
