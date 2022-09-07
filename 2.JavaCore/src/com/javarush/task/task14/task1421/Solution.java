package com.javarush.task.task14.task1421;

/* 
Singleton
*/

public class Solution {
    public static void main(String[] args) {
        Singleton singletonOne = Singleton.getInstance();
        Singleton singletonTwo = Singleton.getInstance();
        System.out.println(singletonOne);
        System.out.println(singletonTwo);
    }
}
