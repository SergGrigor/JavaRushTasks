package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file1 = new BufferedReader(new FileReader(console.readLine()));
             BufferedReader file2 = new BufferedReader(new FileReader(console.readLine()))) {
            List<String> lines1 = countLines(file1);
            List<String> lines2 = countLines(file2);

            int i = 0;
            int j = 0;

            while ((i < lines1.size()) && (j < lines2.size())) {
                if (lines1.get(i).equals(lines2.get(j))) {
                    lines.add(new LineItem(Type.SAME, lines1.get(i)));
                    i++;
                    j++;
                } else if ((j + 1 < lines2.size()) && lines1.get(i).equals(lines2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                    j++;
                } else if ((i + 1 < lines1.size()) && lines1.get(i + 1).equals(lines2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                    i++;
                }
            }
            while (i < lines1.size()) {
                lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                i++;
            }
            while (j < lines2.size()) {
                lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                j++;
            }

            for (LineItem line: lines) {
                System.out.println(line.type + " " + line.line);
            }

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    private static List<String> countLines (BufferedReader reader) throws IOException {
        List<String> strings = new ArrayList<>();
        while (reader.ready()) {
            strings.add(reader.readLine());
        }
        return strings;
    }
}
