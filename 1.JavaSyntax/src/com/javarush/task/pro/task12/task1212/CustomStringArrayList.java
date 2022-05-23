package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        //напишите тут ваш код
        if (size == capacity) {
            capacity = (int) (1.5 * capacity);
            String[] elementsMore = new String[(int) capacity];
            System.arraycopy(elements, 0, elementsMore, 0, elements.length);
            elements = elementsMore;
        }
    }

}
