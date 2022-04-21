package com.javarush.task.pro.task02.task0214;

import java.util.Scanner;

/* 
Чтение и преобразование строк
*/

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        //Создаём переменные
        Scanner keyboard = new Scanner(System.in);
        String line1 = keyboard.nextLine();
        String line2 = keyboard.nextLine();
        String line3 = keyboard.nextLine();

        //Выводим на экран с преобразванием
        System.out.println(line3);
        System.out.println(line2.toUpperCase());
        System.out.println(line1.toLowerCase());

    }
}
