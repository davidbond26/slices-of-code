import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        int[][] board = new int[3][3];
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) board[i][j] = 0;
        }
        boolean gameInProgress = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Hi, this is the current state of the tic tac toe board:\n");
        dispBoard(board);
        char winner = ' ';
        while (gameInProgress) {
            boolean xCorrectFormat = false;
            boolean oCorrectFormat = false;
            while (!xCorrectFormat) {
                System.out.print("Player 1 make a move (row(abc))(column(123)): ");
                String xMove = input.nextLine();
                if (isCorrectFormat(xMove, board)) {
                    if (xMove.charAt(0) == 'a') board[0][Integer.parseInt(xMove.substring(1, 2)) - 1] = 1;
                    else if (xMove.charAt(0) == 'b') board[1][Integer.parseInt(xMove.substring(1, 2)) - 1] = 1;
                    else if (xMove.charAt(0) == 'c') board[2][Integer.parseInt(xMove.substring(1, 2)) - 1] = 1;
                    xCorrectFormat = true;
                    if (isFull(board)) gameInProgress = false;
                } else System.out.println("Invalid Input");
                if (isWinningState(board)) {
                    winner = 'X';
                    xCorrectFormat = true;
                    gameInProgress = false;
                }
            }
            dispBoard(board);
            while (!oCorrectFormat && gameInProgress) {
                System.out.print("Player 2 make a move (row(abc))(column(123)): ");
                String xMove = input.nextLine();
                if (isCorrectFormat(xMove, board)) {
                    if (xMove.charAt(0) == 'a') board[0][Integer.parseInt(xMove.substring(1, 2)) - 1] = 2;
                    else if (xMove.charAt(0) == 'b') board[1][Integer.parseInt(xMove.substring(1, 2)) - 1] = 2;
                    else if (xMove.charAt(0) == 'c') board[2][Integer.parseInt(xMove.substring(1, 2)) - 1] = 2;
                    oCorrectFormat = true;
                    if (isFull(board)) gameInProgress = false;
                } else System.out.println("Invalid Input");
                if (isWinningState(board)) {
                    winner = 'O';
                    gameInProgress = false;
                    oCorrectFormat = true;
                }
            }
            if (gameInProgress) dispBoard(board);
        }
        if (winner != ' ') System.out.println(winner + "s won the game!");
        else System.out.println("It's a tie!");
    }
    public static void dispBoard(int[][] board) {
        for (int i = 0; i <= 2; i++) {
            if (i == 0) System.out.println("   1   2   3 ");
            for (int j = 0; j <= 2; j++) {
                if (j == 0) {
                    if (i == 0) System.out.print("a ");
                    else if (i == 1) System.out.print("b ");
                    else System.out.print("c ");
                }
                if (board[i][j] == 0) System.out.print("   ");
                else if (board[i][j] == 1) System.out.print(" x ");
                else if (board[i][j] == 2) System.out.print(" o ");
                if (j != 2) System.out.print("|");
            }
            if (i != 2) System.out.println("\n  --- --- ---");
            else System.out.println("\n");
        }
    }
    public static boolean isCorrectFormat(String xMove, int[][] board) {
        if (xMove.length() >= 2 && "123".contains(xMove.substring(1, 2))) {
            if (xMove.charAt(0) == 'a') return board[0][Integer.parseInt(xMove.substring(1, 2)) - 1] == 0;
            else if (xMove.charAt(0) == 'b') return board[1][Integer.parseInt(xMove.substring(1, 2)) - 1] == 0;
            else if (xMove.charAt(0) == 'c') return board[2][Integer.parseInt(xMove.substring(1, 2)) - 1] == 0;
        }
        return false;
    }
    public static boolean isWinningState(int[][] board) {
        if ((board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1) || (board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2)) return true;
        if ((board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1) || (board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2)) return true;
        if ((board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1) || (board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2)) return true;
        if ((board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) || (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2)) return true;
        if ((board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) || (board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2)) return true;
        if ((board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1) || (board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2)) return true;
        if ((board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1) || (board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2)) return true;
        return (board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1) || (board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2);
    }
    public static boolean isFull(int[][] board) {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }
}
