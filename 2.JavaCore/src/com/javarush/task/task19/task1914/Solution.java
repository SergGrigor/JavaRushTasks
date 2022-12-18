package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String string = outputStream.toString();
        string = string.replaceAll("\\p{Cntrl}", "");
        String[] strings = string.split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[2]);
        int c = 0;
        String symbolMath = strings[1];
        if (symbolMath.equals("+")) {
            c = a + b;
        }
        if (symbolMath.equals("-")) {
            c = a - b;
        }
        if (symbolMath.equals("*")) {
            c = a * b;
        }
        System.setOut(consoleStream);
        System.out.println(string + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

