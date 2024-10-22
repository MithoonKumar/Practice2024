package org.snakeAndLadderGame;

public class Player {
    private String playerName;
    private Cell currentCell;

    public Player(String playerName, Cell currentCell) {
        this.playerName = playerName;
        this.currentCell = currentCell;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public String getPlayerName() {
        return playerName;
    }
}
