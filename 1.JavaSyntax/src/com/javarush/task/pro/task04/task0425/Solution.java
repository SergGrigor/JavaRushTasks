package com.javarush.task.pro.task04.task0425;

/* 
Диггер (1)
*/

public class Solution {
    public static String bug = "🐛";
    public static String robot = "🤖";
    public static String land = "🌍";
    public static String death = "💀";
    public static String hole = " ";


    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && j == 3) {
                    System.out.print(robot);
                } else if (i == 9) {
                    System.out.print(bug);
                } else {
                    System.out.print(land);
                }
            }
            System.out.println();
        }
    }
}
