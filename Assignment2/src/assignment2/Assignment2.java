/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Scanner;

/**
 *
 * @author Laurens
 */
public class Hangman{
    private String word;
    private StringBuilder attempt;
    private StringBuilder triedLetters;
    private int tries;
       
    
    WordReader wr = new WordReader("Words.txt");

    public Hangman(){
        this.word = wr.wordReader();
        
    }
    
    public Hangman(String word){
        this.word = word;
        
    }
    
    
    public StringBuilder MakeDottedLine(){
        /* This function makes a dotted line(word) which is the same size as
        word */
        for (int i = 0; i < word.length(); i++){
            this.attempt.append('.');
        }
        return this.attempt;
    }
    
    public void PlayHangman(){
        char letterTry;
        Scanner scan = new Scanner(System.in);
        boolean notFinished = true;
        tries = 0;
        while (tries < 10 || notFinished){
            System.out.println("Enter a letter and press enter to try it.");
            letterTry = scan.next().charAt(0);
            TryLetter(letterTry);
            notFinished = !WordFinished();
            System.out.println("You have " + this.tries + " tries left.");
            System.out.println("the currently known word is: " + this.attempt);
            System.out.println("The letters you tried are: " + 
                    this.triedLetters);
        }
    }
    
    public boolean WordFinished(){
        // checks if word and attempt are the same
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) != attempt.charAt(i))
                return false;
        }
        return true;
    }
    
    public StringBuilder TryLetter(char letter){
        String bufferattempt = this.attempt.toString();
        boolean letterFound = false;
        for (int i = 0; i < triedLetters.length(); i++){
            if (triedLetters.charAt(i) == letter){
            System.out.println("This letter has already been tried");
            return this.attempt;
            }
        }
        for (int i = 0; i < word.length(); i++){
            char test = word.charAt(i);
            if (test == letter){
                letterFound = true;
                this.attempt = this.attempt.replace(i, i + 1, bufferattempt);
                System.out.println(letter + " is in the word.");
            }
        }
        if (!letterFound){
            System.out.println(letter + " is not in the word.");
            this.tries++;
        }
        this.triedLetters.append(letter);
        return this.attempt;
    }
}
