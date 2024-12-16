package Atlassian;

import java.util.*;

public class SnakeGameImpl implements SnakeGame{

    private Deque<Position> queue;
    private int screenWidth;
    private int screenHeight;
    private int counterOfMoves;
    private HashSet<Position> snakeBodyOccupancy;
    private boolean gameOverStatus;

    public SnakeGameImpl(int screenHeight, int screenWidth) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        queue = new LinkedList<>();
        Position fPos = new Position(0,0);
        Position sPos = new Position(0,1);
        Position tPos = new Position(0,1);
        queue.add(fPos);
        queue.add(sPos);
        queue.add(tPos);
        this.snakeBodyOccupancy = new HashSet<>();
        snakeBodyOccupancy.add(fPos);
        snakeBodyOccupancy.add(sPos);
        snakeBodyOccupancy.add(tPos);
        this.counterOfMoves = 0;
        this.gameOverStatus = false;
    }


    private Position getNewPos(Position position, Direction direction) {
        int newRow = position.row;
        int newCol = position.col;;
        if (direction.equals(Direction.RIGHT)) {
            newCol = (position.col + 1)%screenWidth;
        }
        if (direction.equals(Direction.LEFT)) {
            newCol = ((position.col - 1)%screenWidth + screenWidth)%screenWidth;
        }

        if (direction.equals(Direction.DOWN)) {
            newRow = (position.col + 1)%screenHeight;
        }
        if (direction.equals(Direction.UP)) {
            newRow = ((position.col - 1)%screenHeight + screenHeight)%screenHeight;
        }

        return new Position(newRow, newCol);

    }

    @Override
    public void moveSnake(Direction direction) {
        if (gameOverStatus) {
            throw new RuntimeException("The game is already over");
        }
        if (counterOfMoves < 5) {
            Position lastPos = this.queue.getLast();
            this.queue.removeLast();
            this.snakeBodyOccupancy.remove(lastPos);
            Position firstPos = this.queue.getFirst();
            Position newPos = this.getNewPos(firstPos, direction);
            if (this.snakeBodyOccupancy.contains(newPos)) {
                this.gameOverStatus = true;
            } else {
                this.queue.addFirst(newPos);
                this.snakeBodyOccupancy.add(newPos);
                this.counterOfMoves++;
            }
        } else {
            Position firstPos = this.queue.getFirst();
            Position newPos = this.getNewPos(firstPos, direction);
            if (this.snakeBodyOccupancy.contains(newPos)) {
                this.gameOverStatus = true;
            } else {
                this.queue.addFirst(newPos);
                this.snakeBodyOccupancy.add(newPos);
                this.counterOfMoves = 0;
            }
        }
    }

    @Override
    public boolean isGameOver() {
        return this.gameOverStatus;
    }

}


