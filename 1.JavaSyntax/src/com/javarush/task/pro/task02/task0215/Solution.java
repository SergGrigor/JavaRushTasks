package com.javarush.task.pro.task02.task0215;

import java.util.Scanner;

/* 
Чтение чисел
*/

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner key = new Scanner(System.in);
        int number1 = key.nextInt();
        int number2 = key.nextInt();
        int number3 = key.nextInt();

        System.out.println((number1 + number2 + number3)/3);

    }
}
