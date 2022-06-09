package com.javarush.task.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collection<String> collection = list;
        Iterable<String> iterable = collection;
        Object object = iterable;
        //object.equals();// сравнение
        //object.hashCode();
        object.toString();
        object.getClass();
        //object.wait();
        object.notify();
        object.notifyAll();
        //Objects.hashCode();
        Objects.hash();
        Class<? extends String> aClass = "Вася".getClass();

    }

}
