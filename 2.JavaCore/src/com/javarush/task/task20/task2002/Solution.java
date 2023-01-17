package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Электрики\\Desktop\\Программирование\\Test.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\Электрики\\Desktop\\Программирование\\Test.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User sergey = new User();
            sergey.setFirstName("Sergey");
            sergey.setLastName("Grig");
            sergey.setBirthDate(new Date(87, 5, 28));
            sergey.setMale(true);
            sergey.setCountry(User.Country.RUSSIA);
            User polina = new User();
            polina.setFirstName("Polina");
            polina.setLastName("Bereg");
            polina.setBirthDate(new Date(90, 5, 23));
            polina.setMale(false);
            polina.setCountry(User.Country.RUSSIA);
            javaRush.users.add(sergey);
            javaRush.users.add(polina);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            System.out.println(javaRush.hashCode() == loadedObject.hashCode());
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            String newLine = System.lineSeparator();
            if (this.users != null) {
                outputStream.write(("yes" + newLine).getBytes());
                for (User user: this.users) {
                    outputStream.write((user.getFirstName() + newLine).getBytes());
                    outputStream.write((user.getLastName() + newLine).getBytes());
                    outputStream.write((user.getBirthDate().getTime() + newLine).getBytes());
                    outputStream.write((user.isMale() + newLine).getBytes());
                    outputStream.write((user.getCountry().getDisplayName() + newLine).getBytes());
                }
            } else {
                outputStream.write(("no" + newLine).getBytes());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            String newLine = System.lineSeparator();
            StringBuilder builder = new StringBuilder("");
            while (inputStream.available() > 0) {
                builder.append((char) inputStream.read());
            }
            String[] strings = builder.toString().split(newLine);
            if (strings[0].equals("yes")) {
                for (int i = 1; i < strings.length; i += 5) {
                    User user = new User();
                    user.setFirstName(strings[i]);
                    user.setLastName(strings[i + 1]);
                    user.setBirthDate(new Date(Long.parseLong(strings[i + 2])));
                    user.setMale(Boolean.parseBoolean(strings[i + 3]));
                    String countryString = strings[i + 4];
                    if (countryString.equals("Russia")) {
                        user.setCountry(User.Country.RUSSIA);
                    }
                    if (countryString.equals("Ukraine")) {
                        user.setCountry(User.Country.UKRAINE);
                    }
                    if (countryString.equals("Other")) {
                        user.setCountry(User.Country.OTHER);
                    }
                    this.users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
