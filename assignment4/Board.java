/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author  Laurens Kubat   s4626249
 * @author  Reinier Sanders s4335422
 */
public class Board {
    private final int size = 3;
    private final String board[][];
    private Player player1;
    private Player player2;
    private boolean player1Turn;
    
    public Board() {
        this.board = new String[size][size];
        setBoard(board);
        this.player1Turn = true;
    }
    
    private void setBoard(String board[][]) {
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                board[col][row] = " ";
            }
        }
    }
    
    public void setPlayer1(Player player) {
        this.player1 = player;
    }
    
    public void setPlayer2(Player player) {
        this.player2 = player;
        System.out.println("\n" + this.player1.getName() +  "'s turn.");
    }
    
    public void play() {
            if (player1Turn) {
                int x = player1.getX();
                int y = player1.getY();
                if (player1 instanceof HumanPlayer && !board[x][y].equals(" ")) {
                    System.out.println("That spot isn't empty!\n");
                    System.out.println(this.toString());
                    return;
                } else if(!board[x][y].equals(" ")) {
                    return;
                } else {
                    board[x][y] = player1.getColor();
                    player1Turn = false;
                    System.out.println("\n" + player2.getName() +  "'s turn.");
                }
            } else {
                int x = player2.getX();
                int y = player2.getY();
                if (player2 instanceof HumanPlayer && !board[x][y].equals(" ")) {
                    System.out.println("That spot isn't empty!\n");
                    System.out.println(this.toString());
                    return;
                } else if(!board[x][y].equals(" ")) {
                    return;
                } else {
                    board[x][y] = player2.getColor();
                    player1Turn = true;
                    System.out.println("\n" + player1.getName() +  "'s turn.");
                }
            }
            System.out.println(this.toString());
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
                    System.out.println(player1.getName() + " wins!");
                else
                    System.out.println(player2.getName() + " wins!");
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
                    System.out.println(player1.getName() + " wins!");
                else
                    System.out.println(player2.getName() + " wins!");
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
                    System.out.println(player1.getName() + " wins!");
                else
                    System.out.println(player2.getName() + " wins!");
            return true;
        }
        // Check if bottomleft to topright diagonal has won.
        if(board[2][0].equals(board[1][1]) &&
                board[2][0].equals(board[0][2])
                && !board[2][0].equals(" ")
                && !board[1][1].equals(" ")
                && !board[0][2].equals(" ")) {
            if(!player1Turn)
                    System.out.println(player1.getName() + " wins!");
                else
                    System.out.println(player2.getName() + " wins!");
            return true;
        }
        // Check if draw.
        if(isFull()) {
            return false;
        }
        return false;
    }
    
    private boolean isFull() {
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if(board[col][row].equals(" "))
                    return false;
            }
        }
        return true;
    }
    
    public Board getBoard() {
        return this;
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
        out+= "\n";
        return out;
    }
}
