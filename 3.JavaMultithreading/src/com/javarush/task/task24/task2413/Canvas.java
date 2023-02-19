package com.javarush.task.task24.task2413;

import java.util.Arrays;

public class Canvas {

    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }

    public void setPoint(double x, double y, char c) {
        int roundX = (int) Math.round(x);
        int roundY = (int) Math.round(y);
        if (!(roundX < 0 || roundY < 0 ||roundY >= this.matrix.length || roundX >= this.matrix.length)) {
            this.matrix[roundY][roundX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + (double) j, y + (double) i, c);
                }
            }
        }
    }

    public void clear() {
        matrix = new char[height + 2][width + 2];
    }

    public void print() {
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
