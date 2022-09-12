package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) {
        try {
            ImageReader imageReader;
            switch (imageType) {
                case BMP:
                    imageReader = new BmpReader();
                    return imageReader;

                case JPG:
                    imageReader = new JpgReader();
                    return imageReader;

                case PNG:
                    imageReader = new PngReader();
                    return imageReader;

                default:
                    throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
