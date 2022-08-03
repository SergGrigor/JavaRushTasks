package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int min(int number1, int number2) {
        if (number1 > number2) {
            return number2;
        } else {
            return number1;
        }
    }
    public static long min(long number1, long number2) {
        if (number1 > number2) {
            return number2;
        } else {
            return number1;
        }
    }
    public static double min(double number1, double number2) {
        if (number1 > number2) {
            return number2;
        } else {
            return number1;
        }
    }
}
