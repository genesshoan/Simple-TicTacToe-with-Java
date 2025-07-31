package game.player;

import game.Board;
import game.Console;

/**
 * Abstract class representing a player in the game.
 */
public abstract class Player {
    /* Symbol of the player ('X' or 'O'). */
    final private char symbol;

    /**
     * Constructor to initialize a player with a symbol and type.
     *
     * @param symbol The player's symbol ('X' or 'O').
     */
    public Player(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the symbol of the game.player.
     *
     * @return The player's symbol.
     */
    public char getSymbol() {
        return this.symbol;
    }

    /**
     * Abstract method to be implemented by subclasses for playing the game.
     * This method will contain the logic for how the player makes a move.
     * @param board Current state of the board
     * @param console Console interface for I/O
     */
    public abstract void play(Board board, Console console);
}
