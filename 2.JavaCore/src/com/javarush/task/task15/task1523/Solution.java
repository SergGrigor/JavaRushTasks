package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    private Solution(String string) {
        System.out.println(string);
    }

    public Solution(int n) {
        System.out.println(n);
    }

    protected Solution(short s) {
        System.out.println(s);
    }

    Solution(boolean bool) {
        System.out.println(bool);
    }

    public static void main(String[] args) {

    }
}

