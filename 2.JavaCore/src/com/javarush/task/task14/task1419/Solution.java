package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.prefs.BackingStoreException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() throws MissingResourceException {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e1) {
            exceptions.add(e1);
        }
        try {
            int [] numbers = {0};
            int number = numbers[1];
        } catch (Exception e2) {
            exceptions.add(e2);
        }
        try {
            int numberString = Integer.parseInt("String");
        } catch (Exception e3) {
            exceptions.add(e3);
        }
        try {
            String string = null;
            string.getBytes();
        } catch (Exception e4) {
            exceptions.add(e4);
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e5) {
            exceptions.add(e5);
        }
        try {
            throw new MissingResourceException("String", "Solution", "a");
        } catch (Exception e6) {
            exceptions.add(e6);
        }
        try {
            throw new ClassCastException();
        } catch (Exception e7) {
            exceptions.add(e7);
        }
        try {
            throw new ArrayStoreException();
        } catch (Exception e8) {
            exceptions.add(e8);
        } try {
            throw new IllegalMonitorStateException();
        } catch (Exception e9) {
            exceptions.add(e9);
        } try {
            throw new IllegalThreadStateException();
        } catch (Exception e10) {
            exceptions.add(e10);
        }


    }
        //напишите тут ваш код
}
