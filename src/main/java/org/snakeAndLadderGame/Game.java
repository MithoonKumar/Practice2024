package org.snakeAndLadderGame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> playerList;
    private GameState gameState;
    private int currPlayerIndex;
    private Dice dice;

    public Game(Board board) {
        this.board = board;
        this.playerList = new ArrayList<>();
        this.gameState = GameState.NOT_STARTED;
        this.dice = new Dice();
    }

    public void startGame(int numPlayers, String [] playerNames) {
        this.gameState = GameState.IN_PROGRESS;
        this.playerList.clear();
        for (int i=0; i<numPlayers; i++) {
            this.playerList.add(new Player(playerNames[i], this.board.getCellList().get(0)));
        }
        this.currPlayerIndex = 0;
    }

    public void play() {
        if (this.gameState == GameState.NOT_STARTED || this.gameState == GameState.COMPLETED) {
            throw new SnakeAndLadderGameException("Please start another game");
        }
        int diceValue = this.dice.getNextRandomNum();
        Cell currentCell = this.playerList.get(currPlayerIndex).getCurrentCell();
        int nextCellId = diceValue + currentCell.getPositionId();

        if (nextCellId >= this.board.getCellList().size()) {
            System.out.println("This is move is out of bounds");
            return;
        }

        if (this.board.getCellList().get(nextCellId).getSnake() != null) {
            nextCellId = this.board.getCellList().get(nextCellId).getSnake().getTailCellId();
        } else if (this.board.getCellList().get(nextCellId).getLadder() != null) {
            nextCellId = this.board.getCellList().get(nextCellId).getLadder().getDestCellId();
        }



        if (isGameCompleted(nextCellId)) {
            System.out.println("Player:" + this.playerList.get(this.currPlayerIndex).getPlayerName() + " has won the game");
            this.gameState = GameState.COMPLETED;
        }
        this.playerList.get(currPlayerIndex).setCurrentCell(this.board.getCellList().get(nextCellId));
        System.out.println("Player with name:" + this.playerList.get(currPlayerIndex).getPlayerName() + " has reached " + nextCellId);
        this.setNextPlayerTurn();
    }

    private boolean isGameCompleted(int positionId) {
        if (this.board.getCellList().size() - 1 == positionId) {
            return true;
        }
        return false;
    }

    private void setNextPlayerTurn() {
        this.currPlayerIndex++;
        this.currPlayerIndex = this.currPlayerIndex%this.playerList.size();
    }

    public boolean isGameCompleted() {
        return this.gameState.equals(GameState.COMPLETED);
    }
}
