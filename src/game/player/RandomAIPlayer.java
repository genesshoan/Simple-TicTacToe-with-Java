package game.player;

import game.Board;
import game.Console;
import java.util.Random;

/**
 * Class representing an AI player that makes random moves on the board.
 */
public class RandomAIPlayer extends Player {
    /**
     * Constructor to initialize a player with a symbol and type.
     *
     * @param symbol The player's symbol.
     */
    public RandomAIPlayer(char symbol) {
        super(symbol);
    }

    /**
     * Executes the human player's turn by asking a valid coordinate.
     *
     * @param board The current game board.
     * @param console The console interface for I/O.
     */
    @Override
    public void play(Board board, Console console) {
        Random rand = new Random(System.currentTimeMillis());
        boolean validMove = false;

        console.printMessage("Player " + getSymbol() + " is thinking...\n");
        do {
            int rowIndex = rand.nextInt(board.SIZE);
            int colIndex = rand.nextInt(board.SIZE);
            if (board.isValid(rowIndex, colIndex)) {
                validMove = true;
                board.placeMove(rowIndex, colIndex, getSymbol());
                console.printMessage("Player " + getSymbol() + " move to: (" +  rowIndex + ", " + colIndex + ")\n");
            }
        } while (!validMove);
    }
}