/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class Assignment4 {
    private static int col, row;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TicTacToe game = new TicTacToe();
        System.out.println("X's turn.");
        System.out.println(game.toString());
        while(!game.winning()) {
            System.out.println("Please enter column to place X or O:");
            col = Integer.parseInt(br.readLine());
            System.out.println("Please enter row to place X or O:");
            row = Integer.parseInt(br.readLine());
            game.play(col, row);
            System.out.println(game.toString());
        }
    }
    
}
