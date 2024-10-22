package org.snakeAndLadderGame;


public class Dice {

    public int getNextRandomNum() {
        int min = 1;
        int max = 6;
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
