package com.javarush.task.pro.task03.task0314;

import java.util.Scanner;

/* 
Сломанная клавиатура
*/

public class Solution {
    public static String secret = "AmIGo";

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String secretWord = scanner.nextLine();

        if (secret.equalsIgnoreCase(secretWord)) {
            System.out.println("доступ разрешен");
        } else {
            //напишите тут ваш код
            System.out.println("доступ запрещен");
        }
    }
}
