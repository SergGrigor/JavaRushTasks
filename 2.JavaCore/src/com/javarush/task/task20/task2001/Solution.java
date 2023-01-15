package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Электрики\\Desktop\\Программирование\\Test.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\Электрики\\Desktop\\Программирование\\Test.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(somePerson.hashCode() + "..." +  ivanov.hashCode());
            System.out.println(somePerson.equals(ivanov));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

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
                        String assetPrice = asset.getPrice() + newLine;
                        outputStream.write(assetName.getBytes());
                        outputStream.write(assetPrice.getBytes());
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
                    for (int i = 2; i < strings.length - 1; i += 2) {
                        this.assets.add(new Asset(strings[i], Double.parseDouble(strings[i + 1])));
                    }
                    this.name = nameLoadHuman;
                } else {
                    this.name = nameLoadHuman;
                }
            }
        }
    }
}
