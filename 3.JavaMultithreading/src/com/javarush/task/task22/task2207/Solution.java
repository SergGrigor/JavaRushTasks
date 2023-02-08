package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new  InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            List<String> lines = new ArrayList<>();
            while (reader.ready()) {
                lines.addAll(Arrays.asList(reader.readLine().split(" ")));
            }
            for (int i = 0; i < lines.size(); i++) {
                for (int j = 0; j < lines.size(); ) {
                    if (i >= lines.size()) {
                        break;
                    }
                    if (lines.get(j).equals(new StringBuilder(lines.get(i)).reverse().toString()) && j != i) {
                        Pair pair = new Pair();
                        pair.first = lines.get(j);
                        pair.second = lines.get(i);
                        result.add(pair);
                        lines.remove(j);
                        lines.remove(i);
                        j = 0;
                    } else {
                        j++;
                    }
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
