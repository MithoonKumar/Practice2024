package Atlassian;

public class Main {

    /*
    1 1 1 0 0
    0 0 0 0 0
    0 0 0 0 0
    0 0 0 0 0
    0 0 0 0 0
    */

    public static void main(String[] args) {
        SnakeGameImpl snakeGame = new SnakeGameImpl(5, 5);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);

        System.out.println(snakeGame.isGameOver());


        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);


        System.out.println(snakeGame.isGameOver());


        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);

        System.out.println(snakeGame.isGameOver());

        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);
        snakeGame.moveSnake(Direction.RIGHT);

        System.out.println(snakeGame.isGameOver());
    }
}
