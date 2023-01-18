package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Электрики\\Desktop\\Программирование\\Test.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\Электрики\\Desktop\\Программирование\\Test.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(ivanov.equals(somePerson));
            System.out.println(ivanov.hashCode() + " ... " + somePerson.hashCode());
            inputStream.close();

        } catch (IOException e) {;
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {;
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            if (this.name != null) {
                String newLine = System.lineSeparator();
                String nameHuman = Human.this.name;
                String isAssets = this.assets != null ? "yes" + newLine : "no" + newLine;
                outputStream.write(nameHuman.concat(newLine).getBytes());
                outputStream.write(isAssets.getBytes());
                if (isAssets.equals("yes" + newLine)) {
                    for (Asset asset : this.assets) {
                        String assetName = asset.getName() + newLine;
                        outputStream.write(assetName.getBytes());
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            String newLine = System.lineSeparator();
            StringBuilder builder = new StringBuilder("");
            while (inputStream.available() > 0) {
                builder.append((char) inputStream.read());
            }
            String object = builder.toString();
            String[] strings = object.split(newLine);
            String nameLoadHuman = strings[0];
            if (nameLoadHuman != null) {
                if (strings[1].equals("yes")) {
                    for (int i = 2; i < strings.length; i++) {
                        this.assets.add(new Asset(strings[i]));
                    }
                    this.name = nameLoadHuman;
                } else {
                    this.name = nameLoadHuman;
                }
            }
        }
    }
}
