package com.javarush.task.pro.task03.task0317;

import java.util.Scanner;

/* 
Пищевой конвеер
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner con = new Scanner(System.in);
        int num1 = con.nextInt();
        int num2 = con.nextInt();
        int num3 = con.nextInt();
        int num4 = con.nextInt();

        //алгоритм работы конвеера
        if (num1 > 0)
            System.out.println(num1);
        if (num2 > 0)
            System.out.println(num2);
        if (num3 > 0)
            System.out.println(num3);
        if (num4 > 0)
            System.out.println(num4);
    }
}
