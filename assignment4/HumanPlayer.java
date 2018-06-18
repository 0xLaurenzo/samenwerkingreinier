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
public class HumanPlayer implements Player {
    private String name;
    private String color;
    
    public HumanPlayer(){
        
    }
    @Override
    public void play(int x_cord, int y_cord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String getName() {
        return this.name;
    }
    
    public void getNameFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the player's name");
        setName(scan.nextLine());
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public void getColorFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the players symbol (X/O)");
        String color = scan.nextLine();
        if (color != ("X") || color != ("O")){
            System.out.println("Please enter only an X or O");
            getColorFromUser();
            } else {
                setColor(color);
            }
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    
}
