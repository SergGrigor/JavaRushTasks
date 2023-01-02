package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
            for (String line: strings) {
                int day;
                int month;
                int year;
                StringBuffer name = new StringBuffer();
                String[] splits = line.split(" ");
                for (int i = 0; i < splits.length - 3; i++) {
                    name.append(splits[i]).append(" ");
                }
                year = Integer.parseInt(splits[splits.length - 1]);
                month = Integer.parseInt(splits[splits.length - 2]) - 1;
                day = Integer.parseInt(splits[splits.length - 3]);
                Calendar birthDay = new GregorianCalendar(year, month, day);
                PEOPLE.add(new Person(name.toString().trim(), birthDay.getTime()));
            }
        }
    }
}
