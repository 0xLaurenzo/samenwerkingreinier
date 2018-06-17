/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class TicTacToe {
    private final int size = 3;
    private final String board[][];
    private final String player1 = "X";
    private final String player2 = "O";
    private int movesUsed = 0;
    private boolean player1Turn = true;
    
    public TicTacToe() {
        this.board = new String[size][size];
        setBoard(board);
    }
    
    private void setBoard(String board[][]) {
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                board[col][row] = " ";
            }
        }
    }
    
    public void play(int col, int row) {
        if (!board[col][row].equals(" ")) {
            System.out.println("That spot isn't empty!\n");
        } else {
            if (player1Turn) {
                board[col][row] = player1;
                player1Turn = false;
                movesUsed++;
                System.out.println("\nO's turn.");
            } else {
                board[col][row] = player2;
                player1Turn = true;
                movesUsed++;
                System.out.println("\nX's turn.");
            }
        }
    }
    
    public boolean winning() {
        // Check if a row has won.
        for(int row = 0; row < size; row++) {
            if(board[0][row].equals(board[1][row]) 
                    && board[1][row].equals(board[2][row])
                    && !board[0][row].equals(" ")
                    && !board[1][row].equals(" ")
                    && !board[2][row].equals(" ")) {
                if(!player1Turn)
                    System.out.println("X wins!");
                else
                    System.out.println("O wins!");
                return true;
            }
        }
        // Check if a column has won.
        for(int col = 0; col < size; col++) {
            if(board[col][0].equals(board[col][1])
                    && board[col][1].equals(board[col][2])
                    && !board[col][0].equals(" ")
                    && !board[col][1].equals(" ")
                    && !board[col][2].equals(" ")) {
                if(!player1Turn)
                    System.out.println("X wins!");
                else
                    System.out.println("O wins!");
                return true;
            }
        }
        // Check if topleft to bottomright diagonal has won.
        if(board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2])
                && !board[0][0].equals(" ")
                && !board[1][1].equals(" ")
                && !board[2][2].equals(" ")) {
            if(!player1Turn)
                    System.out.println("X wins!");
                else
                    System.out.println("O wins!");
            return true;
        }
        // Check if bottomleft to topright diagonal has won.
        if(board[2][0].equals(board[1][1]) &&
                board[2][0].equals(board[0][2])
                && !board[2][0].equals(" ")
                && !board[1][1].equals(" ")
                && !board[0][2].equals(" ")) {
            if(!player1Turn)
                    System.out.println("X wins!");
                else
                    System.out.println("O wins!");
            return true;
        }
        // Check if draw.
        if(movesUsed == 9) {
            System.out.println("It's a draw!");
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String out = "";
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if(board[col][row] == null)
                    out += " ";
                else
                    out += board[col][row];
                if(col != size - 1)
                    out += "|";
            }
            if(row != size - 1) {
                out += "\n";
                out += "-----\n";
            }
        }
        return out;
    }
}
