import java.util.Scanner;

public class Main {

    // this part of the represent the tic-tac-toe board.
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };


    // this part of the code represent the current player and the game start with x and players take turn switching between x and o.
    private static char player = 'X';

    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);

        
        while (true) {
            // this part of the board display the game board
            displayBoard();

            // this part of code check if there's user input available
            if (consoleInput.hasNext()) {
                // this part of the code reads the user input
                String move = consoleInput.next();

                // this part of the code if the mode is validate 
                if (validMove(move)) {
                    int row = Character.getNumericValue(move.charAt(0)) - 1;
                    int colum = Character.getNumericValue(move.charAt(1)) - 1;

                    // this part of the code make the move
                    board[row][colum] = player;

                    // this part of the code check for a winner
                    if (winner()) {
                        displayBoard();
                        System.out.println("Player " + player + " wins!");
                        break;
                    }

                    // this part of the code check for a draw
                    if (boardFull()) {
                        displayBoard();
                        System.out.println("It's a draw!");
                        break;
                    }

                    // this part of the code switch to the next player
                    player = (player == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                break;
            }
        }

        consoleInput.close();
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean validMove(String move) {
        if (move.length() == 2) {
            int row = Character.getNumericValue(move.charAt(0)) - 1;
            int colum = Character.getNumericValue(move.charAt(1)) - 1;
            return (row >= 0 && row < 3 && colum >= 0 && colum < 3 && board[row][colum] == ' ');
        }
        return false;
    }

    private static boolean winner() {
        // this part of the code check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean boardFull() {
        // this part of the check if the board is full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}



       