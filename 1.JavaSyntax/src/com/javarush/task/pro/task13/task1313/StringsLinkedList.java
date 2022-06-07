package com.javarush.task.pro.task13.task1313;

import java.util.ArrayList;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    private Node lastElement;//создание временной ссылки

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        //напишите тут ваш код

        //если в списке один элемент
        if (first.next == null) {
            Node newElement = new Node(); //создание нового элемента
            newElement.value = value; //запись значения
            last.prev = newElement; //запись последнего элемента в Node last
            first.next = newElement;
            lastElement = newElement;
        } else {
            Node newElement = new Node(); //создание нового элемента
            newElement.value = value; //запись значения
            last.prev = newElement; //запись последнего элемента в Node last
            newElement.prev = lastElement;
            lastElement.next = newElement;
            lastElement = newElement;
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
