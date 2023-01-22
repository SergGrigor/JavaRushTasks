package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName , true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("C:\\Users\\Электрики\\Desktop\\Программирование\\Test.txt");
        solution.writeObject("test1");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Электрики\\Desktop\\Программирование\\Test1.txt");
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Электрики\\Desktop\\Программирование\\Test1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        outputStream.writeObject(solution);
        solution = (Solution) inputStream.readObject();
        solution.writeObject("test2");
        solution.close();
    }
}
