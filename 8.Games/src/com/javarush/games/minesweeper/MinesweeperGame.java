package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 27;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags = countMinesOnField;
    private int countClosedTiles = SIDE * SIDE;
    private int score;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(8) < 1;
                if (isMine) {
                    countMinesOnField++;
                    countFlags = countMinesOnField;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGERED);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine) {
                    List<GameObject> neighbors = getNeighbors(gameField[y][x]);
                    for (GameObject gameObjectMine : neighbors) {
                        if (gameObjectMine.isMine) {
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (!(gameObject.isOpen || gameObject.isFlag || isGameStopped)) {
            gameObject.isOpen = true;
            setCellColor(x, y, Color.WHITE);
            countClosedTiles--;
            if (gameObject.isMine) {
                setCellValueEx(gameObject.x, gameObject.y, Color.RED, MINE);
                setCellTextSize(gameObject.x, gameObject.y, 70);
                gameOver();
            } else if (gameObject.countMineNeighbors == 0) {
                setCellValue(gameObject.x, gameObject.y, "");
                List<GameObject> neighbors = getNeighbors(gameObject);
                for (GameObject neighbor : neighbors) {
                    if (!neighbor.isOpen) {
                        openTile(neighbor.x, neighbor.y);
                    }
                }
            } else {
                setCellNumber(x, y, gameObject.countMineNeighbors);
                setCellTextSize(x, y, 70);
                score += 5;
                setScore(score);
            }
            if (countClosedTiles == countMinesOnField && !gameObject.isMine) {
                win();
            }
        }
    }

    private void markTile(int x, int y) {
        if (!isGameStopped) {
            GameObject gameObjects = gameField[y][x];
            if (!gameObjects.isOpen) {
                if (countFlags == 0 && !gameObjects.isFlag) {

                } else {
                    if (gameObjects.isFlag) {
                        gameObjects.isFlag = false;
                        setCellValue(x, y, "");
                        countFlags++;
                        setCellColor(x, y, Color.ORANGERED);
                    } else {
                        gameObjects.isFlag = true;
                        setCellValue(x, y, FLAG);
                        setCellTextSize(x, y, 70);
                        countFlags--;
                        setCellColor(x, y, Color.GREEN);
                    }
                }
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.DARKRED, "Вы проиграли!", Color.GREY, 60);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLUE, "Победа!!!", Color.YELLOWGREEN, 80);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(score);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        } else {
            openTile(x, y);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}