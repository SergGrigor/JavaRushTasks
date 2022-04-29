package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int numberString = scanner.nextInt();
        multiArray = new int[numberString][];
        for (int i = 0; i < numberString; i++) {
            int numberNumbers = scanner.nextInt();
            multiArray[i] = new int[numberNumbers];
            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.print("[" + "]");
            }
            System.out.println();
        }
    }
}
