package com.javarush.task.pro.task05.task0506;

import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int numberN = scanner.nextInt();
        array = new int[numberN];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numberN; i++) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < numberN; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        System.out.println(min);
    }
}
