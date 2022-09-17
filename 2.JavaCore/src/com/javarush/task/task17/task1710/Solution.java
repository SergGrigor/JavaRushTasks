package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        if (args[0].equals("-c")) {
            String[] dateBD = args[3].split("/");
            Date bd = new Date(Integer.parseInt(dateBD[2]) - 1900, Integer.parseInt(dateBD[1]) - 1, Integer.parseInt(dateBD[0]));
            if (args[2].equals("м")) {
                allPeople.add(allPeople.size(), Person.createMale(args[1], bd));
                System.out.println(allPeople.size() - 1);
            } else {
                allPeople.add(allPeople.size(), Person.createFemale(args[1], bd));
                System.out.println(allPeople.size() - 1);
            }
        }
        if (args[0].equals("-r")) {
            int id = Integer.parseInt(args[1]);
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
        if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            String name = args[2];
            String sex = args[3];
            String[] dateBD = args[4].split("/");
            Date bd = new Date(Integer.parseInt(dateBD[2])- 1900, Integer.parseInt(dateBD[1]) - 1, Integer.parseInt(dateBD[0]));
            allPeople.get(id).setName(name);
            allPeople.get(id).setBirthDate(bd);
            if (sex.equals("м")) {
                allPeople.get(id).setSex(Sex.MALE);
            } else {
                allPeople.get(id).setSex(Sex.FEMALE);
            }
        }
        if (args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]);
            Date bd = null;
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(bd);
        }

    }
}
