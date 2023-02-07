package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] strings = string.substring(string.indexOf(" ") + 1).split(" ");
        if (strings.length >= 4) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                builder.append(strings[i] + " ");
            }
            return builder.toString().trim();
        } else {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
