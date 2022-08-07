package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

public class MinesweeperGame extends Game {

    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        System.out.println(countMinesOnField);
    }

    private void createGame() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField[x].length; y++) {
                boolean mine = false;
                if (getRandomNumber(10) == 5) {
                    mine = true;
                    countMinesOnField += 1;
                }
                gameField[x][y] = new GameObject(y, x, mine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }
}
