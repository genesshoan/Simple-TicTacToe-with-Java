package game;

import java.util.Scanner;
import game.Board;
import game.GameMode;

public class Console {
    private final Scanner input = new Scanner(System.in);

    /**
    * Prints a message to console.
    *
    * @param message The message to print.
    */
    public void printMessage(String message) {
        System.out.print(message);
    }

    /**
     * Cleans the input buffer.
     */
    public void clearBuffer() {
        input.nextLine();
    }

    /**
     * Prompts the user for a row or column to place their move.
     *
     * @param message The message to prompt the user.
     * @return An integer between 0 and 2 inclusive.
     */
    public int askForCoordinate(String message) {
        while (true) {
            System.out.print(message);
            if (input.hasNextInt()) {
                int coordinate = input.nextInt();
                if (coordinate >= 0 && coordinate <= 2) {
                    return coordinate;
                } else {
                    printMessage("Invalid coordinate. The coordinate must be between 0 and 2!\n");
                }
            } else {
                printMessage("Invalid coordinate. The coordinate must be a number between 0 and 2!\n");
                clearBuffer();
            }
        }
    }

    /**
     * Prints the current state of the board to the console.
     *
     * @param board The board to be displayed.
     */
    public void printBoard(Board board) {
        char[][] boardCopy = board.getBoard();
        int size = board.SIZE;
        printMessage("\n");
        for (int i = 0; i < size; i++) {
            System.out.println(boardCopy[i][0] + " | " +  boardCopy[i][1] + " | " + boardCopy[i][2]);
            if (i < size - 1) {
                printMessage("---+---+---\n");
            }
        }
        printMessage("\n");
    }

    private void printMenuOptions() {
        printMessage("Please select an option:\n");
        printMessage("1. Player vs Player.\n");
        printMessage("2. Player vs Random AI.\n");
        printMessage("3. Player vs minMax AI.\n");
        printMessage("0. Close game.\n");
        printMessage("Select an option: ");
    }

    public GameMode selectMenuOption() {
        int option = -1;
        while (true) {
            printMenuOptions();
            if (input.hasNextInt()) {
                option = input.nextInt();

                switch (option) {
                    case 0:
                        printMessage("Game closed. Bya!\n");
                        return GameMode.EXIT;
                    case 1:
                        printMessage("Starting Human vs Human game...\n");
                        return GameMode.HUMAN;
                    case 2:
                        printMessage("Starting Human vs Random IA game...\n");
                        return GameMode.RANDOM_IA;
                    case 3:
                        printMessage("Starting Human vs MinMax IA game...\n");
                        return GameMode.MINMAX_IA;
                    default:
                        printMessage("Invalid option. Please choose a number between 0 and 3.\n");
                        clearBuffer();
                }
            } else {
                printMessage("Invalid option. The option must be a number between 0 and 3!\n");
                clearBuffer();
            }
        }
    }
}
