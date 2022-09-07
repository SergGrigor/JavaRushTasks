package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Timer;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());

        System.out.println(getNOD(first, second));
    }

    private static int getNOD(int first, int second) {
        if (first < 1 || second < 1) {
            throw new IllegalArgumentException();
        }

        while (first != second) {
            if (first > second) {
                first -= second;
            }
            if (second > first) {
                second -= first;
            }
        }
        return first;
    }


//        int numberOne;
//        int numberTwo;
//        int NOD;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            System.out.println("Введите первое число:");
//            numberOne = Integer.parseInt(reader.readLine());
//            System.out.println("Введите второе число:");
//            numberTwo = Integer.parseInt(reader.readLine());
//            if (numberOne >= 0 && numberTwo >= 0) {
//                System.out.println("Вычисляю наибольший общий делитель (НОД)...");
//                NOD = computeNOD(numberOne, numberTwo);
//                System.out.println(NOD);
//            }
//        }
//    }
//
//    public static int computeNOD(int numberOne, int numberTwo) {
//        while (true) {
//            if (numberOne != 0 && numberTwo != 0) {
//                if (numberOne > numberTwo) {
//                    numberOne = numberOne % numberTwo;
//                } else {
//                    numberTwo = numberTwo % numberOne;
//                }
//            } else {
//                if (numberOne == 0) {
//                    return numberTwo;
//                } else {
//                    return numberOne;
//                }
//            }
//        }
//    }
}
