package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int numberN = scanner.nextInt();
        if (numberN > 0) {
            int[] numbers = new int[numberN];
            for (int i = 0; i < numberN; i++) {
                numbers[i] = scanner.nextInt();
            }
            if (numberN % 2 == 0) {
                for (int i = numberN - 1; i >= 0; i--) {
                    System.out.println(numbers[i]);
                }
            } else {
                for (int i = 0; i < numberN; i++) {
                    System.out.println(numbers[i]);
                }
            }
        }
    }
}
