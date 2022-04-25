package com.javarush.task.pro.task04.task0404;

/* 
Заполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String string = "Q";
        int i = 0;
        while (i < 5) {
            int m = 0;
            while (m < 10) {
                System.out.print(string);
                m++;
            }
            System.out.println();
            i++;
        }

    }
}