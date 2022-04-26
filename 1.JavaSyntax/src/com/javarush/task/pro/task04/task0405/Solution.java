package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String b = "Б";
        String space = " ";
        int i = 0;

        while (i < 10) {
            System.out.print(b);
             if (i == 0 || i == 9) {
                 int m = 0;
                 while (m < 18) {
                     System.out.print(b);
                     m++;
                 }
             } else {
                 int j = 0;
                 while (j < 18) {
                     System.out.print(space);
                     j++;
                 }
             }

            System.out.println(b);
            i++;
        }
    }
}