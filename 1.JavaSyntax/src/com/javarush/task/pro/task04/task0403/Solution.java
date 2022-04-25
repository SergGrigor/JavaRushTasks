package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int summa = 0;
        boolean isExit = true;

        while (isExit) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                summa = summa + number;
            } else {
                String numb = scanner.nextLine();
                if (numb.equals("ENTER")) {
                    System.out.println(summa);
                    isExit = false;
                }
            }
        }
    }
}