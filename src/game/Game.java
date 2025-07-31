package game;

import game.player.*;
import java.util.Random;

/**
 * Main class game. Initializes the game and players.
 */
public class Game {
    /* Represents the game's players. */
    final Player playerOne;
    final Player playerTwo;

    /**
     * Constructor to initialize a new game.
     *
     * @param gameMode The current game mode.
     */
    public Game(GameMode gameMode) {
        playerOne = new HumanPlayer('X');
        switch(gameMode) {
            case HUMAN:
                playerTwo = new HumanPlayer('O');
                break;
            case RANDOM_IA:
                playerTwo = new RandomAIPlayer('O');
                break;
            case MINMAX_IA:
                playerTwo = new MinMaxAI('O');
                break;
            default:
                throw new IllegalArgumentException("Unsupported game mode: " + gameMode);
        }
    }

    /**
     * Randomly determines which player starts the game.
     * This adds unpredictability and fairness to gameplay.
     *
     * @return true if the playerOne starts, false otherwise.
     */
    private boolean playerOneStart() {
        Random rand = new Random(System.currentTimeMillis());
        return rand.nextBoolean();
    }

    /**
     * Main game loop. Alternates turns between players until win or tie.
     * Uses polymorphism to handle different player types (Human, AI) uniformly.
     *
     * @param board Current board state.
     * @param console Interface to handle the user I/O.
     */
    public void gameLoop(Board board, Console console) {
        boolean endGame = false;
        boolean playerOneTurn = playerOneStart();
        console.printMessage(playerOneTurn ? "Player " + playerOne.getSymbol() + " starts!" : "Player " + playerTwo.getSymbol() + " starts!");
        console.printBoard(board);

        while (!endGame) {
            if (playerOneTurn) {
                playerOne.play(board, console);
            } else {
                playerTwo.play(board, console);
            }
            console.printBoard(board);

            char winner = board.getWinner();
            if (winner != '\0') {
                console.printMessage("Player " + winner + " won!\n");
                endGame = true;
            } else if (board.isFull()) {
                console.printMessage("Nobody won, it's a tie!\n");
                endGame = true;
            }

            playerOneTurn = !playerOneTurn;
        }
    }
}
