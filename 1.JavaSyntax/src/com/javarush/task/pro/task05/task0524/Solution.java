package com.javarush.task.pro.task05.task0524;

/* 
Взлом Кибердракона
*/

public class Solution {
    public static int[] coordinates;

    public static void main(String[] args) {
        //напишите тут ваш код
        coordinates = new int[200];
        for (int i = 0; i < 200; i++) {
            if ( i % 2 == 0) {
                coordinates[i] = ((i / 2) * 10);
            } else {
                    coordinates[i] = ((i / 2) * 10) + (i % 2);
            }
            System.out.print(coordinates[i] + " ");
        }


    }
}