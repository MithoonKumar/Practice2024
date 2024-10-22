package org.snakeAndLadderGame;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGameDriver {
    public static void main(String[] args) {
        // Set up board
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            cells.add(new Cell(i, null, null));  // Initially, no snakes or ladders
        }

        // Set up snakes
        cells.set(16, new Cell(16, new Snake(6), null));  // Snake from cell 16 to cell 6
        cells.set(47, new Cell(47, new Snake(26), null)); // Snake from cell 47 to cell 26
        cells.set(49, new Cell(49, new Snake(11), null)); // Snake from cell 49 to cell 11

        // Set up ladders
        cells.set(2, new Cell(2, null, new Ladder(38)));  // Ladder from cell 2 to cell 38
        cells.set(15, new Cell(15, null, new Ladder(44))); // Ladder from cell 15 to cell 44
        cells.set(22, new Cell(22, null, new Ladder(58))); // Ladder from cell 22 to cell 58

        // Create board
        Board board = new Board(cells);

        // Create game instance
        Game game = new Game(board);

        // Start game with 2 players
        String[] playerNames = {"Alice", "Bob"};
        game.startGame(2, playerNames);

        // Play game in a loop until game completes
        while (true) {
            game.play();

            if (game.isGameCompleted()) {
                System.out.println("Game Over");
                break;
            }
        }
    }
}
