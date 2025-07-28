package game;

/**
 *  Represents the Tic Tac Toe game board
 */
public class Board {
    /* Size of the board (3x3). */
    final int SIZE = 3;

    /* Internal 2D array to store board cells */
    protected char[][] board;

    /**
     * Initializes an empty 3x3 board.
     */
    public Board() {
        this.board = new char[SIZE][SIZE];
        for  (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = ' ';
            }
        }
    }

    /**
     * Checks if the given position is occupied.
     *
     * @param row The row index (0-based).
     * @param col The column index (0-based).
     * @return if true is the cell is not empty.
     */
    public boolean isOccupied(int row, int col) {
        return this.board[row][col] != ' ';
    }

    /**
     * Checks if the given position is within board bounds.
     *
     * @param row The row index.
     * @param col The column index.
     * @return true if the position is inside the board.
     */
    public boolean isInBounds(int row, int col) {
        return (row >= 0 && row < SIZE) && (col >= 0 && col < SIZE);
    }

    /**
     * Checks if a move is valid (in bounds and unoccupied).
     *
     * @param row The row index.
     * @param col The column index.
     * @return true if the move is valid.
     */
    public boolean isValid(int row, int col) {
        return isInBounds(row, col) && !isOccupied(row, col);
    }

    /**
     * Places a move on the board.
     *
     * @param row The row index.
     * @param col The column index.
     * @param symbol The player's symbol ('X' or 'O').
     */
    public void placeMove(int row, int col, char symbol) {
        this.board[row][col] = symbol;
    }

    /**
     * Prints the current state of the board to the console.
     */
    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println(this.board[i][0] + " | " +  this.board[i][1] + " | " + this.board[i][2]);
            if (i < SIZE - 1) {
                System.out.println("---+---+---");
            }
        }
    }

    /**
     * check if it is a tie (the board is full)
     *
     * @return true if is the board is filled.
     */
    public boolean isFull() {
        for (char[] row : this.board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks whether the current board state results in a win.
     *
     * @return true if any row, column, or diagonal contains the same non-empty symbol.
     */
    public boolean checkWin() {
        // Rows
        for (int i = 0; i < SIZE; i++) {
            if (isOccupied(i, 0) && (this.board[i][0] == this.board[i][1]) && (this.board[i][0] == this.board[i][2])) {
                return true;
            }
        }

        // Columns
        for (int i = 0; i < SIZE; i++) {
            if (isOccupied(0, i) && (this.board[0][i] == this.board[1][i]) && (this.board[0][i] == this.board[2][i])) {
                return true;
            }
        }

        // Main diagonal
        if (isOccupied(0, 0) && (this.board[0][0] == this.board[1][1]) && (this.board[0][0] == this.board[2][2])) {
            return true;
        }

        // Secondary diagonal
        return isOccupied(0, 2) && (this.board[0][2] == this.board[1][1]) && (this.board[0][2] == this.board[2][0]);
    }
}
