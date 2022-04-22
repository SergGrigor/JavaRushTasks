package com.javarush.task.pro.task03.task0307;

import java.util.Scanner;

/* 
Работать или не работать - вот в чем вопрос
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner key = new Scanner(System.in);
        byte age = key.nextByte();
        if (age < 20 || age > 60)
            System.out.println("можно не работать");
    }
}
