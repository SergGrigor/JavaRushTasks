package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream fileOutput;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutput = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        fileOutput.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutput.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutput.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        this.flush();
        String phrase = "JavaRush © All rights reserved.";
        this.write(phrase.getBytes());
        fileOutput.close();
    }

    @Override
    public void flush() throws IOException {
        fileOutput.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
