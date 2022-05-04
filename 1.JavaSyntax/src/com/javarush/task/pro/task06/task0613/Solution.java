package com.javarush.task.pro.task06.task0613;

/* 
Города-гиганты
*/

public class Solution {
    public static String city = "Токио";
    public static double population = 34.5;
    public static String cityJakarta = "Джакарта";
    public static double populationJakarta = 25.3;
    public static String citySeal = "Сеул";
    public static double populationSeal = 25.2;
    public static String cityDheli = "Дели";
    public static double populationDheli = 23.1;
    public static String cityNewYork = "Нью-Йорк";
    public static double populationNewYork = 21.6;

    public static void main(String[] args) {
        printCityPopulation(cityJakarta, populationJakarta);
        printCityPopulation(citySeal, populationSeal);
        printCityPopulation(cityDheli, populationDheli);
        printCityPopulation(cityNewYork, populationNewYork);
    }

    public static void printCityPopulation(String city, double population){
        System.out.println("Население города " + city + " составляет " + population + " млн человек.");
        city = Solution.city;
        population = Solution.population;
        System.out.println("В то время как в самом густонаселенном городе " + city + " население составляет " + population + " млн человек.");
    }
}
