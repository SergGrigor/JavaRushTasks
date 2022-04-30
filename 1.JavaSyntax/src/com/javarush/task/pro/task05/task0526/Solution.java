package com.javarush.task.pro.task05.task0526;

/* 
Атака вирусов
*/


import java.util.Arrays;

public class Solution {
    public static int[][] array;

    public static void main(String[] args) {
        //printArray();

        //напишите тут ваш код
        array = new int[3][4];
        array[0] = new int[]{1, 2, 3, 4};
        array[1] = new int[]{4, 5, 6, 7};
        array[2] = new int[]{7, 8, 9, 0};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }

        int[] tmp = array[0];
        array[0] = array[2];
        array[2] = tmp;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }

        //printArray();
    }

    /*public static void printArray() {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

     */
}
