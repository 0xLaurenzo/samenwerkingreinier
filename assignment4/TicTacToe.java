/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.Scanner;

/**
 *
 * @author Laurens
 */
public class TicTacToe {
    private Board board;
    public TicTacToe (){
        this.board = new Board();
    }
    
    public void play(){
        setPlayers();
        while(!board.winning()) {
            board.play(); 
        }
        if (board.getPlayer1Turn()) {
            System.out.println("Player 2 Won!");
        } else {
            System.out.println("Player 1 Won!");
        }
    }
    
    public void setPlayers() {
        setPlayer1();
        setPlayer2(); 
        
    }
    
    public void setPlayer1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want player 1 to be a human or AI player?(H/A)");
        String player1 = scan.nextLine();
        switch (player1) {
            case "H" : board.setPlayer1(new HumanPlayer()); break;
            case "A" : board.setPlayer1(new AIPlayer()); break;
            default :   System.out.println("Please enter H or A"); setPlayer1();
        } 
    }
    
    public void setPlayer2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want player 2 to be a human or AI player?(H/A)");
        String player2 =  scan.nextLine();
        switch (player2) {
            case "H" : board.setPlayer2(new HumanPlayer()); break;
            case "A" : board.setPlayer2(new AIPlayer()); break;
            default :   System.out.println("Please enter H or A"); setPlayer2();
        }
    }
    
}
