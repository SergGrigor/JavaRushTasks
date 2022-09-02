package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            switch (country) {
                case "Russia":
                    hen = new RussianHen();
                    return hen;
                case "Ukraine":
                    hen = new UkrainianHen();
                    return hen;
                case "Belarus":
                    hen = new BelarusianHen();
                    return hen;
                case "Moldova":
                    hen = new MoldovanHen();
                    return hen;
                default:
                    return null;
            }
        }
    }


}
