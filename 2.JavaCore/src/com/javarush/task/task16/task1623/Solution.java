package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount = 1;
    static String nameThread = String.valueOf(createdThreadCount);

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {

        public GenerateThread() {
            super(nameThread);
            createdThreadCount++;
            nameThread = String.valueOf(createdThreadCount);
            this.start();
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }

        @Override
        public void run() {
            if (createdThreadCount <= count) {
                GenerateThread generateThread = new GenerateThread();
                System.out.println(generateThread.toString());
            }
        }
    }
}
