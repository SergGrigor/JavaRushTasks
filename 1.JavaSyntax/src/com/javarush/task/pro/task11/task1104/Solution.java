package com.javarush.task.pro.task11.task1104;

/* 
Конвертер строки
*/

public class Solution {
    public static void main(String[] args) {
        String string = "12.84";
        //напишите тут ваш код
        double number = Double.parseDouble(string);
        int numberRound = (int) Math.round(number);
        System.out.println(numberRound);
    }
}
