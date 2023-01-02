package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самый богатый
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
                    number = number + treeMap.get(strings[0]);
                    treeMap.put(strings[0], number);
                }
            }
            List<Map.Entry<String, Double>> collect = treeMap
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                    .collect(Collectors.toList());
            Double max = collect
                    .stream()
                    .max(Comparator.comparingDouble(value -> value.getValue()))
                    .get().getValue();
            List<Map.Entry<String, Double>> entries = treeMap.entrySet()
                    .stream()
                    .filter( el -> el.getValue().equals(max))
                    .collect(Collectors.toList());
            for (Map.Entry<String, Double> element: entries) {
                System.out.println(element.getKey());
            }
        }
    }
}
