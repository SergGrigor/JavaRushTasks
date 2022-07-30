package com.javarush.task.pro.task16.task1614;

import java.time.Instant;

/* 
Конец времен
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {
        Instant instantMilli = Instant.ofEpochMilli(Long.MAX_VALUE);
        return instantMilli;
    }

    static Instant getMaxFromSeconds() {
        Instant instantSec = Instant.ofEpochSecond(Instant.MAX.getEpochSecond());
        return instantSec;
    }

    static Instant getMaxFromSecondsAndNanos() {
        Instant instantSecAndNano = Instant.ofEpochSecond(Instant.MAX.getEpochSecond(), Instant.MAX.getNano());
        return instantSecAndNano;
    }
}
