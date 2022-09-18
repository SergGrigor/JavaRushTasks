package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        String name = args[i];
                        String[] dateBD = args[i + 2].split("/");
                        Date bd = new Date(Integer.parseInt(dateBD[2]) - 1900, Integer.parseInt(dateBD[1]) - 1, Integer.parseInt(dateBD[0]));
                        if (args[i + 1].equals("м")) {
                            allPeople.add(allPeople.size(), Person.createMale(name, bd));
                            System.out.println(allPeople.size() - 1);
                        } else {
                            allPeople.add(allPeople.size(), Person.createFemale(name, bd));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        int id = Integer.parseInt(args[i]);
                        String name = args[i + 1];
                        String sex = args[i + 2];
                        String[] dateBD = args[i + 3].split("/");
                        Date bd = new Date(Integer.parseInt(dateBD[2]) - 1900, Integer.parseInt(dateBD[1]) - 1, Integer.parseInt(dateBD[0]));
                        allPeople.get(id).setName(name);
                        allPeople.get(id).setBirthDate(bd);
                        if (sex.equals("м")) {
                            allPeople.get(id).setSex(Sex.MALE);
                        } else {
                            allPeople.get(id).setSex(Sex.FEMALE);
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        Date bd = null;
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(bd);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String sex;
                        String name = allPeople.get(id).getName();
                        Date bd = allPeople.get(id).getBirthDate();
                        if (allPeople.get(id).getSex() == Sex.MALE) {
                            sex = "м";
                        } else {
                            sex = "ж";
                        }
                        System.out.println(name + " " + sex + " " + dateFormat.format(bd));
                    }
                }
                break;
        }
    }
}
