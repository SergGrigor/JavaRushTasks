package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int minimum1 = scanner.nextInt(); // 15
        int minimum2 = scanner.nextInt(); // 2
        if (minimum2 < minimum1) {
            int tmp = minimum2;
            minimum2 = minimum1; // 15
            minimum1 = tmp; // 2
        }
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (minimum1 == minimum2 && number > minimum1) {
                minimum2 = number;
            } else if (number < minimum1) {
                minimum2 = minimum1;
                minimum1 = number;
            } else if (number > minimum1 && number < minimum2) {
                minimum2 = number;
            }

        }
        System.out.println(minimum2);

    }
}