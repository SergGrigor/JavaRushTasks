package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;
import java.time.Month;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        return LocalDate.now();
    }

    static LocalDate ofExample() {
        return LocalDate.of(2020, Month.SEPTEMBER, 12);
    }

    static LocalDate ofYearDayExample() {
        return LocalDate.ofYearDay(2020, ofExample().getDayOfYear());
    }

    static LocalDate ofEpochDayExample() {
        int countDays = 0;
        for (int i = 1970; i < 2020; i++) {
            countDays += LocalDate.of(i, Month.DECEMBER, 31).getDayOfYear();
        }
        countDays += LocalDate.of(2020, Month.SEPTEMBER, 12).getDayOfYear() - 1;
        return LocalDate.ofEpochDay(countDays);
    }
}
