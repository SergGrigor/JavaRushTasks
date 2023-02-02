package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    @Override
    public Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for (Map.Entry<String, User> entry: this.users.entrySet()) {
            solution.users.put(entry.getKey(), entry.getValue().clone());
        }
        return solution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }


    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() throws CloneNotSupportedException {
            return new User(this.age, this.name);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof User)) return false;
            User user = (User) obj;
            if (user.age != this.age) return false;
            if (!Objects.equals(user.name, this.name)) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return 31 * (this.age * this.name.length());
        }
    }
}
