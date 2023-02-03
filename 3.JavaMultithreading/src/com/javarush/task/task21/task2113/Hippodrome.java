package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Первая", 3, 0));
        horseList.add(new Horse("Вторая", 3, 0));
        horseList.add(new Horse("Третья", 3, 0));
        game = new Hippodrome(horseList);
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse: getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse: getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }
}
