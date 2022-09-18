package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int compareQuality;
        int compareDistance;
        if (this.getDistance() < o.getDistance()) {
            compareDistance = 1;
        } else if (this.getDistance() > o.getDistance()) {
            compareDistance = -1;
        } else {
            compareDistance = 0;
        }
        if (this.getQuality() > o.getQuality()) {
            compareQuality = 1;
        } else if (this.getQuality() < o.getQuality()) {
            compareQuality = -1;
        } else {
            compareQuality = 0;
        }
        if (compareDistance + compareQuality > 0) {
            return 1;
        } else if (compareDistance + compareQuality < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
