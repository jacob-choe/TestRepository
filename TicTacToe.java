import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // empty board
        // ---
        // ---
        // ---
        char[][] board = new char[3][3];
        int row;
        int col;
        Scanner scnr = new Scanner(System.in);
        boolean winner = false;
        boolean fullBoard = false;
        System.out.println("Player 1: x"); // show each player's chip
        System.out.println("Player 2: o");
        initializeBoard(board); // add '-' to every element
        printBoard(board); // display board
        while(!(winner) || !(fullBoard)){
            System.out.println("Player1's Turn (x):");
            System.out.println("Enter a row number (0, 1, or 2): ");
            row = scnr.nextInt();
            System.out.println("Enter a column number (0, 1, or 2): ");
            col = scnr.nextInt();
            if (row > 2 || row < 0 || col > 2 || col <0){
                while (row > 2 || row < 0 || col > 2 || col <0) {
                    System.out.println("This position is off the bounds of the board! Try again.");
                    System.out.println("Enter a row number (0, 1, or 2): ");
                    row = scnr.nextInt();
                    System.out.println("Enter a column number (0, 1, or 2): ");
                    col = scnr.nextInt();
                }
                }
            if (board[row][col] != '-'){
                while (board[row][col] != '-'){
                    System.out.println("Someone has already made a move at this position! Try again.");
                    System.out.println("Enter a row number (0, 1, or 2): ");
                    row = scnr.nextInt();
                    System.out.println("Enter a column number (0, 1, or 2): ");
                    col = scnr.nextInt();
                }
            }
            board[row][col] = 'x';
            winner = checkIfWinner(board, 'x');
            fullBoard = boardIsFull(board);
            printBoard(board);
            if (winner){
                break;
            }
            if (fullBoard){
                break;
            }
            System.out.println("Player2's Turn (o):");
            System.out.println("Enter a row number (0, 1, or 2): ");
            row = scnr.nextInt();
            System.out.println("Enter a column number (0, 1, or 2): ");
            col = scnr.nextInt();
            if (row > 2 || row < 0 || col > 2 || col <0){
                while (row > 2 || row < 0 || col > 2 || col <0) {
                    System.out.println("This position is off the bounds of the board! Try again.");
                    System.out.println("Enter a row number (0, 1, or 2): ");
                    row = scnr.nextInt();
                    System.out.println("Enter a column number (0, 1, or 2): ");
                    col = scnr.nextInt();
                }
            }
            if (board[row][col] != '-'){
                while (board[row][col] != '-'){
                    System.out.println("Someone has already made a move at this position! Try again.");
                    System.out.println("Enter a row number (0, 1, or 2): ");
                    row = scnr.nextInt();
                    System.out.println("Enter a column number (0, 1, or 2): ");
                    col = scnr.nextInt();
                }
            }
            board[row][col] = 'o';
            winner = checkIfWinner(board, 'o');
            fullBoard = boardIsFull(board);
            printBoard(board);
            if (winner){
                break;
            }
            if (fullBoard){
                break;
            }
        }

    }

    public static void initializeBoard(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean checkIfWinner(char[][] board, char chipType){ // checks to see if there is a winner
        int count = 0; // keeps track of chips in a row
        // returns true if there is a winner
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == chipType){
                    count++;
                } else {
                    count = 0;
                }
            }
            if (count == 3){
                if (chipType == 'x'){
                    System.out.println("Player 1 has won!");
                }
                if (chipType == 'o'){
                    System.out.println("Player 2 has won!");
                }
                return true;
            }
            count = 0;
        }
        for (int i = 0; i < board[0].length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[j][i] == chipType){
                    count++;
                } else {
                    count = 0;
                }
            }
            if (count == 3){
                if (chipType == 'x'){
                    System.out.println("Player 1 has won!");
                }
                if (chipType == 'o'){
                    System.out.println("Player 2 has won!");
                }
                return true;
            }
            count = 0;
        }
        return false; // return false if no winner is found
    }

    public static boolean boardIsFull (char[][] board){
        // checks to see if there is a full board
        int count = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j <board[i].length; j++){
                if (board[i][j] != '-'){
                    count++;
                }
            }
        }
        if (count == (board.length) * (board[0].length)){
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }
}
