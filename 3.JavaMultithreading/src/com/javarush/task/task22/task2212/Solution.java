package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        Pattern p = Pattern.compile("\\(\\d{3}\\)");
        Pattern startPlus = Pattern.compile("^\\+");
        Pattern startNumber = Pattern.compile("^\\d");
        Pattern startBracket = Pattern.compile("^\\(");
        Pattern end = Pattern.compile("\\d$");

        if (telNumber == null) return false;

        if (end.matcher(telNumber).find()) {
            if (startPlus.matcher(telNumber).find()) {
                if (p.matcher(telNumber).find()) {
                    String s = telNumber.replaceAll("\\(\\d{3}\\)", "");
                    return s.matches("\\+\\d{9}");
                } else {
                    return telNumber.matches("\\+\\d{12}");
                }
            }
            if (startNumber.matcher(telNumber).find() || startBracket.matcher(telNumber).find()) {
                if (p.matcher(telNumber).find()) {
                    String s = telNumber.replaceAll("\\(\\d{3}\\)", "");
                    return s.matches("\\d{7}");
                } else {
                    return telNumber.matches("\\d{10}");
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("+380501234567" + " - " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567" + " - " + checkTelNumber("+38(050)1234567"));
        System.out.println("(050)1234567" + " - " + checkTelNumber("(050)1234567"));
        System.out.println("0(501)234567" + " - " + checkTelNumber("0(501)234567"));
        System.out.println("+38)050(1234567" + " - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)123-45-67" + " - " + checkTelNumber("+38(050)123-45-67"));
        System.out.println("050ххх4567" + " - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456" + " - " + checkTelNumber("050123456"));
        System.out.println("(0)501234567" + " - " + checkTelNumber("(0)501234567"));
        System.out.println("+38050123456g" + " - " + checkTelNumber("+38050123456g"));
        System.out.println("null"  + " - " + checkTelNumber(null));
    }
}
