package game;

import game.*;

public class Main {
    public static void main(String[] args) {
        boolean shouldClose = false;
        Console console = new Console();
        Board board;
        Game game;

        while (!shouldClose) {
            GameMode gameMode = console.selectMenuOption();
            if (gameMode != GameMode.EXIT) {
                board = new Board();
                game = new Game(gameMode);
                game.gameLoop(board, console);
            } else {
                shouldClose = true;
            }
        }
    }
}
