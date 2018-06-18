/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author  Laurens Kubat   s4626249
 * @author  Reinier Sanders s4335422
 */
public class AIPlayer implements Player {
    private String name;
    private String color;
    private Board board;
    
    public AIPlayer() {
        getNameFromUser();
        getColorFromUser();
    }
    
    @Override
    public int getY() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    @Override
    public int getX() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getColor() {
        return this.color;
    }
    
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    
    public void getNameFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the player's name");
        setName(scan.nextLine());
    }
    
    public void getColorFromUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter " + name + "'s symbol (X/O)");
        String color = Character.toString(scan.next().charAt(0));
        switch(color) {
            case "X" : setColor("X"); break;
            case "O" : setColor("O"); break;
            default : System.out.println("Please enter only X or O"); getColorFromUser();
        }
    }
    
}
