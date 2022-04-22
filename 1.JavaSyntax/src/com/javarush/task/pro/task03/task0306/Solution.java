package com.javarush.task.pro.task03.task0306;

import java.util.Scanner;

/* 
Треугольник
*/

public class Solution {
    private static final String TRIANGLE_EXISTS = "треугольник существует";
    private static final String TRIANGLE_NOT_EXISTS = "треугольник не существует";

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner key = new Scanner(System.in);
        int a = key.nextInt();
        int b = key.nextInt();
        int c = key.nextInt();
        boolean ab = ((a + b) > c);
        boolean bc = ((b + c) > a);
        boolean ac = ((a + c) > b);

        if (ab && bc && ac)
            System.out.println(TRIANGLE_EXISTS);
        else
            System.out.println(TRIANGLE_NOT_EXISTS);
    }
}
