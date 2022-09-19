package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedReader fileReaderOne = new BufferedReader(new FileReader(reader.readLine()));
            BufferedReader fileReaderTwo = new BufferedReader(new FileReader(reader.readLine()));
            while (fileReaderOne.ready()) {
                allLines.add(fileReaderOne.readLine());
            }
            while (fileReaderTwo.ready()) {
                forRemoveLines.add(fileReaderTwo.readLine());
            }
            Solution solution = new Solution();
            solution.joinData();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void joinData() throws CorruptedDataException {
        boolean isContain = false;
        for (int i = 0; i < forRemoveLines.size(); i++) {
                if (allLines.contains(forRemoveLines.get(i))) {
                    isContain = true;
                } else {
                    allLines.clear();
                    throw new CorruptedDataException();
                }
            }
        if (isContain) {
            for (int i = 0; i < forRemoveLines.size(); i++) {
                allLines.remove(forRemoveLines.get(i));
            }
        }
    }
}
