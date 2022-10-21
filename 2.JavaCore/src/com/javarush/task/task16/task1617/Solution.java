package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                while (!isInterrupted() && numSeconds >= 0) {
                    if (numSeconds == 0) {
                        System.out.println("Марш!");
                    } else {
                        System.out.print(numSeconds + " ");
                        Thread.sleep(1000);
                    }
                    numSeconds--;
                }

            } catch (InterruptedException e) {
                if (numSeconds != -1) {
                    System.out.println("Прервано!");
                }
            }

//            try {
//                if (numSeconds == 3) {
//                    while (numSeconds > 0) {
//                        System.out.print(numSeconds + " ");
//                        numSeconds = numSeconds - 1;
//                        Thread.sleep(1000);
//                    }
//                    System.out.print("Марш!");
//                }
//                if (numSeconds == 4) {
//                    while (numSeconds > 0) {
//                        System.out.print(numSeconds + " ");
//                        numSeconds--;
//                        Thread.sleep(1000);
//                    }
//                }
//            } catch (InterruptedException e) {
//                System.out.print("Прервано!");
//            }
        }
    }
}