package com.javarush.task.pro.task03.task0305;

import java.util.Scanner;

/* 
Три числа
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner k = new Scanner(System.in);
        int num1 = k.nextInt();
        int num2 = k.nextInt();
        int num3 = k.nextInt();
        boolean num12 = (num1 == num2);
        boolean num23 = (num2 == num3);
        boolean num13 = (num1 == num3);

        if (num12 & num23) {
            System.out.print(num1 + " " + num2 + " " + num3);
        } else {
            if (num12)
                System.out.print(num1 + " " + num2);
            if (num23)
                System.out.print(num2 + " " + num3);
            if (num13)
                System.out.print(num1 + " " + num3);
        }


    }
}
