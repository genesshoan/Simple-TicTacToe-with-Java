package game.player;

import game.Board;
import game.Console;

/**
 * Class representing an AI player that evaluates best moves on the board and makes them.
 */
public class MinMaxAI extends Player {
    /**
     * Constructor to initialize a player with a symbol and type.
     *
     * @param symbol The player's symbol.
     */
    public MinMaxAI(char symbol) {
        super(symbol);
    }

    /**
     * Evaluates the result of a posible match by attaching a score.
     *
     * @param board The current board state.
     * @param depth The current level of recursion. Used to give preference
     *              to faster wins or slower losses in the MinMax algorithm.
     * @return The total score of the search tree
     */
    private int evaluate(Board board, int depth) {
        char winner = board.getWinner();
        if (winner == getSymbol()) {
            return 10 - depth;
        } else if (winner != '\0') {
            return -10 + depth;
        }
        return 0;
    }

    /**
     * Determines if the game is completed.
     *
     * @param board The current board state.
     * @return true if the games is completed, false otherwise.
     */
    private boolean isFinalCondition(Board board) {
        char winner = board.getWinner();
        return board.isFull() || winner != '\0';
    }

    /**
     * Get the opponent symbol.
     *
     * @return The opponent symbol
     */
    private char getOpponentSymbol() {
        return (getSymbol() == 'X') ? 'O' : 'X';
    }

    /**
     * Determines the total score of the best move to do in the current board state.
     *
     * @param board The current board state.
     * @param depth The current level of recursion. Used to give preference
     *              to faster wins or slower losses in the MinMax algorithm.
     * @param isMaximizing Indicates if is AI's turn or human turn.
     * @return The total score of the current board state.
     */
    private int minMax(Board board, int depth,boolean isMaximizing) {
        if (isFinalCondition(board)) {
            return evaluate(board, depth);
        }

        int bestValue = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        char symbolToTry = isMaximizing ? getSymbol() : getOpponentSymbol();

        for (int i = 0; i < board.SIZE; i++) {
            for (int j = 0; j < board.SIZE; j++) {
                if (!board.isOccupied(i, j)) {
                    board.placeMove(i, j, symbolToTry);

                    int evaluatedValue = minMax(board, depth + 1,!isMaximizing);

                    board.restoreMove(i, j);

                    if (isMaximizing) {
                        bestValue = Math.max(bestValue, evaluatedValue);
                    } else {
                        bestValue = Math.min(bestValue, evaluatedValue);
                    }
                }
            }
        }

        return bestValue;
    }

    /**
     * Make the best move desition based on the current board state and futures moves.
     *
     * @param board Current state of the board
     * @param console Console interface for I/O
     */
    @Override
    public void play(Board board, Console console) {
        int bestValue = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        console.printMessage("Wait... I'm thinking...\n");

        for (int i = 0; i < board.SIZE; i++) {
            for (int j = 0; j < board.SIZE; j++) {
                if (!board.isOccupied(i, j)) {
                    board.placeMove(i, j, getSymbol());
                    int evaluatedValue = minMax(board, 0, false);
                    board.restoreMove(i, j);

                    if (evaluatedValue > bestValue) {
                        bestValue = evaluatedValue;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }
        console.printMessage("Okay, may be here. I'm a genius!\n");
        board.placeMove(bestRow, bestCol, getSymbol());
    }
}
