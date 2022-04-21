package com.javarush.task.pro.task03.task0302;

import java.util.Scanner;

/* 
Призывная кампания
*/

public class Solution {
    public static void main(String[] args) {
        String militaryCommissar = ", явитесь в военкомат";
        //напишите тут ваш код
        Scanner key = new Scanner(System.in);
        String name = key.nextLine();
        int age = key.nextInt();

        //выполнение условия, возраст 18-28
        if (age >= 18 & age <= 28)
            System.out.println(name + militaryCommissar);
    }
}
