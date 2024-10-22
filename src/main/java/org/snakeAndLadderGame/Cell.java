package org.snakeAndLadderGame;

public class Cell {
    private int positionId;
    private Snake snake;
    private Ladder ladder;

    public Cell(int positionId, Snake snake, Ladder ladder) {
        this.positionId = positionId;
        this.snake = snake;
        this.ladder = ladder;
    }

    public int getPositionId() {
        return positionId;
    }

    public Snake getSnake() {
        return snake;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
