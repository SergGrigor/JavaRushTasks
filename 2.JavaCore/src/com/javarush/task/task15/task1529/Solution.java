package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) throws IOException{

    }

    static {
        //add your code here - добавьте код тут
        try {
            reset();
        } catch (Exception e) {

        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        if (word.equals("helicopter")) {
            result = new Helicopter(10);
        }
        if (word.equals("plane")) {
            result = new Plane(25);
        }
        reader.close();
    }
}
