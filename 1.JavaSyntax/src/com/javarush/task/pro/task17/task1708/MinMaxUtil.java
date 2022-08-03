package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.util.Arrays;

public class MinMaxUtil {
    public static int min(int number1, int number2) {
        int [] numbers = {number1, number2};
        Arrays.sort(numbers);
        return numbers[0];
    }
    public static int min(int number1, int number2, int number3) {
        int [] numbers = {number1, number2, number3};
        Arrays.sort(numbers);
        return numbers[0];
    }
    public static int min(int number1, int number2, int number3, int number4) {
        int [] numbers = {number1, number2, number3, number4};
        Arrays.sort(numbers);
        return numbers[0];
    }
    public static int min(int number1, int number2,int number3, int number4, int number5) {
        int [] numbers = {number1, number2, number3, number4, number5};
        Arrays.sort(numbers);
        return numbers[0];
    }
    public static int max(int number1, int number2) {
        int [] numbers = {number1, number2};
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }
    public static int max(int number1, int number2, int number3) {
        int [] numbers = {number1, number2, number3};
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }
    public static int max(int number1, int number2, int number3,int number4) {
        int [] numbers = {number1, number2, number3, number4};
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }
    public static int max(int number1, int number2, int number3, int number4, int number5) {
        int [] numbers = {number1, number2, number3, number4, number5};
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }
}
