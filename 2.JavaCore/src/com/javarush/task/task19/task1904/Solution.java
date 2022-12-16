package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
                String[] substrings =  fileScanner.nextLine().split(" ");
                String lastName = substrings[0];
                String firstName = substrings[1];
                String middleName = substrings[2];
                int day = Integer.parseInt(substrings[3]);
                int mon = Integer.parseInt(substrings[4]) - 1;
                int year = Integer.parseInt(substrings[5]) - 1900;
                return new Person(firstName, middleName, lastName, new Date(year, mon, day));
            }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
