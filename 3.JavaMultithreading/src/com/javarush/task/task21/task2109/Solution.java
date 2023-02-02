package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            C c = new C(super.getI() , super.getJ(), super.getName());
            return c;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof C)) return false;
            C c = (C) obj;
            if (c.getI() != this.getI()) return false;
            if (c.getJ() != this.getJ()) return false;
            if (!Objects.equals(c.getName() , this.getName())) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return this.getI() * this.getJ() * this.getName().length();
        }
    }

    public static void main(String[] args) {

    }
}
