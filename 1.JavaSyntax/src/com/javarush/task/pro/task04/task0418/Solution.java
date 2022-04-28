package com.javarush.task.pro.task04.task0418;

import java.util.Scanner;

/* 
Стакан наполовину пуст или наполовину полон?
*/

public class Solution {
    public static void main(String[] args) {
        double glass = 0.5;
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String who = scanner.nextLine();
        int resultRound = 0;
        if (who.equals("true")) {
            resultRound = (int) Math.ceil(glass);
        } else if (who.equals("false")) {
            resultRound = (int) Math.floor(glass);
        }
        System.out.println(resultRound);
    }
}