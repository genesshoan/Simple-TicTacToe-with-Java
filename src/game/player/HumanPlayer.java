package game.player;

import game.Board;
import game.Console;

public class HumanPlayer extends Player {
    /**
     * Constructor to initialize a player with a symbol and type.
     *
     * @param symbol The player's symbol.
     */
    public HumanPlayer(char symbol) {
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
        boolean validMove = false;
        do {
            int rowIndex = console.askForCoordinate("Player " + getSymbol() + ", enter row (0-2): ");
            int colIndex = console.askForCoordinate("Player " + getSymbol() + ", enter column (0-2): ");
            if (board.isValid(rowIndex, colIndex)) {
                validMove = true;
                board.placeMove(rowIndex, colIndex, getSymbol());
            } else {
                console.printMessage("Invalid coordinate! Please try again.\n");
                console.clearBuffer();
            }

        } while (!validMove);
    }
}
