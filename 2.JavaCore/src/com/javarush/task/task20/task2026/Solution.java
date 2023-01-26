package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    private static int findRight(byte[][] a, int i, int j) {
        int p;
        for (p = j; p < a[i].length - 1; p++) {
            if (a[i][p] == 0) break;
        }
        return p;
    }


    private static int findDown(byte[][] a, int i, int j) {
        int p;
        for (p = i; p < a.length - 1; p++) {
            if (a[p][j] == 0) break;
        }
        return p;
    }

    private static void setNull (byte[][] a , int i, int j, int i2, int j2) {
        for (int x = i; x <= i2; x++) {
            for (int y = j; y <= j2; y++) {
                a[x][y] = 0;
            }
        }
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int temp_i;
        int temp_j;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    count++;
                    temp_j = findRight(a, i, j);
                    temp_i = findDown(a, i, j);
                    setNull(a, i, j, temp_i, temp_j);
                }
            }
        }
        return count;
    }
}
