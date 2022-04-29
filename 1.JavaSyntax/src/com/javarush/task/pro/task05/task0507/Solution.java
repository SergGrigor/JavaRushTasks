package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int numberN = scanner.nextInt();
        array = new int[numberN];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numberN; i++) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < numberN; j++) {
            if (array[j] > max) {
                max = array[j];
            }
        }
        System.out.println(max);
    }
}
