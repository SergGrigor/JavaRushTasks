package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1987, 5,28);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        String[] daysOfWeek = {"Воскресенье", "Понедельник","Вторник",
                               "Среда", "Четверг", "Пятница", "Суббота"};
        String dayOfWeek = daysOfWeek[calendar.get(GregorianCalendar.DAY_OF_WEEK) - 1];
        return dayOfWeek;
    }
}
