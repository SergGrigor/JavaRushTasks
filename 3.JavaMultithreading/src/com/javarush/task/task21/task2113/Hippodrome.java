package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

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
}
