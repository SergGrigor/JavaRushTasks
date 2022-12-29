package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> treeMap = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] strings = reader.readLine().split(" ");
                Double number = Double.parseDouble(strings[1]);
                if (!treeMap.containsKey(strings[0])) {
                    treeMap.put(strings[0], number);
                } else {
                    number += treeMap.get(strings[0]);
                    treeMap.put(strings[0], number);
                }
            }
            Map.Entry.comparingByKey();
            for (Map.Entry<String, Double> element: treeMap.entrySet()) {
                System.out.println(element.getKey() + " " + element.getValue());
            }
        }
    }
}
