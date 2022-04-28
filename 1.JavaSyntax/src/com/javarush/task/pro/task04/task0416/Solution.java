package com.javarush.task.pro.task04.task0416;

import java.util.Scanner;

/* 
Share a Coke
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int jarCola = scanner.nextInt();
        int progammists = scanner.nextInt();
        double jarsProgrammist = (1.0 * jarCola) / progammists;
        System.out.println(jarsProgrammist);

    }
}