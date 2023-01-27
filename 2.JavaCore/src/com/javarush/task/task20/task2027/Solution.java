package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> lines = detectAllWords(crossword, "home", "same");
        System.out.println("List<Word> = " + lines.size());
        for (Word word: lines) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> allWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char startSymbol = word.charAt(0);
            Word finalWord;
            for (int m = 0; m < crossword.length; m++) {

                for (int n = 0; n < crossword[m].length; n++) {
                    if (crossword[m][n] == startSymbol) {
                        finalWord = findRight(crossword, word, m, n);
                        if (finalWord != null) {
                            allWords.add(finalWord);
                        }
                        finalWord = findLeft(crossword, word, m, n);
                        if (finalWord != null) {
                            allWords.add(finalWord);
                        }
                        finalWord = findDown(crossword, word, m, n);
                        if (finalWord != null) {
                            allWords.add(finalWord);
                        }
                        finalWord = findUp(crossword, word, m, n);
                        if (finalWord != null) {
                            allWords.add(finalWord);
                        }
                        finalWord = findRightUp(crossword, word, m, n);
                        if (finalWord != null) {
                            allWords.add(finalWord);
                        }
                        finalWord = findLeftUp(crossword, word, m, n);
                        if (finalWord != null) {
                            allWords.add(finalWord);
                        }
                        finalWord = findRightDown(crossword, word, m, n);
                        if (finalWord != null) {
                            allWords.add(finalWord);
                        }
                        finalWord = findLeftDown(crossword, word, m, n);
                        if (finalWord != null) {
                            allWords.add(finalWord);
                        }
                    }
                }
            }
        }
        return allWords;
    }

    private static Word findRight(int[][] crossword, String word, int x, int y) {
        int startX = y;
        int startY = x;
        int endX = 0;
        int endY = 0;
        int lengthWord = word.length();
        StringBuilder builder = new StringBuilder();
        for (int j = y; (j < crossword[x].length) && (lengthWord > 0); j++) {
            lengthWord--;
            builder.append((char) crossword[x][j]);
            endX = j;
            endY = x;
        }
        if (builder.toString().equals(word)) {
            Word finalWord = new Word(builder.toString());
            finalWord.setStartPoint(startX, startY);
            finalWord.setEndPoint(endX, endY);
            return finalWord;
        } else {
            return null;
        }
    }

    public static Word findLeft(int[][] crossword, String word, int x, int y) {
        int startX = y;
        int startY = x;
        int endX = 0;
        int endY = 0;
        int lengthWord = word.length();
        StringBuilder builder = new StringBuilder();
        for (int i = x; i < x + 1; i++) {
            for (int j = y; (j >= 0) && (lengthWord > 0); j--) {
                lengthWord--;
                builder.append((char) crossword[i][j]);
                endX = j;
                endY = i;
            }
        }
        if (builder.toString().equals(word)) {
            Word finalWord = new Word(builder.toString());
            finalWord.setStartPoint(startX, startY);
            finalWord.setEndPoint(endX, endY);
            return finalWord;
        } else {
            return null;
        }
    }

    public static Word findDown(int[][] crossword, String word, int x, int y) {
        int startX = y;
        int startY = x;
        int endX = 0;
        int endY = 0;
        int lengthWord = word.length();
        StringBuilder builder = new StringBuilder();
        for (int i = x; (i < crossword.length) && (lengthWord > 0); i++) {
            lengthWord--;
            builder.append((char) crossword[i][y]);
            endX = y;
            endY = i;
        }
        if (builder.toString().equals(word)) {
            Word finalWord = new Word(builder.toString());
            finalWord.setStartPoint(startX, startY);
            finalWord.setEndPoint(endX, endY);
            return finalWord;
        } else {
            return null;
        }
    }

    public static Word findUp(int[][] crossword, String word, int x, int y) {
        int startX = y;
        int startY = x;
        int endX = 0;
        int endY = 0;
        int lengthWord = word.length();
        StringBuilder builder = new StringBuilder();
        for (int i = x; (i >= 0) && (lengthWord > 0); i--) {
            lengthWord--;
            builder.append((char) crossword[i][y]);
            endX = y;
            endY = i;
        }
        if (builder.toString().equals(word)) {
            Word finalWord = new Word(builder.toString());
            finalWord.setStartPoint(startX, startY);
            finalWord.setEndPoint(endX, endY);
            return finalWord;
        } else {
            return null;
        }
    }

    public static Word findRightUp(int[][] crossword, String word, int x, int y) {
        int startX = y;
        int startY = x;
        int endX = 0;
        int endY = 0;
        int lengthWord = word.length();
        StringBuilder builder = new StringBuilder();
        int j = y;
        for (int i = x; (i >= 0) && (lengthWord > 0); i--) {
            if ((j < crossword[i].length) && (lengthWord > 0)) {
                builder.append((char) crossword[i][j]);
                endX = j;
                endY = i;
            }
            lengthWord--;
            j++;

        }
        if (builder.toString().equals(word)) {
            Word finalWord = new Word(builder.toString());
            finalWord.setStartPoint(startX, startY);
            finalWord.setEndPoint(endX, endY);
            return finalWord;
        } else {
            return null;
        }
    }

    public static Word findLeftUp(int[][] crossword, String word, int x, int y) {
        int startX = y;
        int startY = x;
        int endX = 0;
        int endY = 0;
        int lengthWord = word.length();
        StringBuilder builder = new StringBuilder();
        int j = y;
        for (int i = x; (i >= 0) && (lengthWord > 0); i--) {
            if ((j >= 0) && (lengthWord > 0)) {
                builder.append((char) crossword[i][j]);
                endX = j;
                endY = i;
            }
            lengthWord--;
            j--;

        }
        if (builder.toString().equals(word)) {
            Word finalWord = new Word(builder.toString());
            finalWord.setStartPoint(startX, startY);
            finalWord.setEndPoint(endX, endY);
            return finalWord;
        } else {
            return null;
        }
    }

    public static Word findRightDown(int[][] crossword, String word, int x, int y) {
        int startX = y;
        int startY = x;
        int endX = 0;
        int endY = 0;
        int lengthWord = word.length();
        StringBuilder builder = new StringBuilder();
        int j = y;
        for (int i = x; (i < crossword.length) && (lengthWord > 0); i++) {
            if ((j < crossword[i].length) && (lengthWord > 0)) {
                builder.append((char) crossword[i][j]);
                endX = j;
                endY = i;
            }
            lengthWord--;
            j++;

        }
        if (builder.toString().equals(word)) {
            Word finalWord = new Word(builder.toString());
            finalWord.setStartPoint(startX, startY);
            finalWord.setEndPoint(endX, endY);
            return finalWord;
        } else {
            return null;
        }
    }

    public static Word findLeftDown(int[][] crossword, String word, int x, int y) {
        int startX = y;
        int startY = x;
        int endX = 0;
        int endY = 0;
        int lengthWord = word.length();
        StringBuilder builder = new StringBuilder();
        int j = y;
        for (int i = x; (i < crossword.length) && (lengthWord > 0); i++) {
            if ((j >= 0) && (lengthWord > 0)) {
                builder.append((char) crossword[i][j]);
                endX = j;
                endY = i;
            }
            lengthWord--;
            j--;

        }
        if (builder.toString().equals(word)) {
            Word finalWord = new Word(builder.toString());
            finalWord.setStartPoint(startX, startY);
            finalWord.setEndPoint(endX, endY);
            return finalWord;
        } else {
            return null;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
