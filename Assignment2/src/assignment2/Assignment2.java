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
public class Assignment2 {

    public static void main(String[] args) {
        
    }
    
}

public class Hangman{
    private StringBuilder word;
    private WordReader wr;
    private StringBuilder attempt;
    private StringBuilder triedLetters;
            
    public Hangman(){
        wr = new WordReader("Words.txt");
        this.word = wr.getWord;
        this.attempt = attempt;
        this.triedLetters = triedLetters;
    }
    
    public Hangman(StringBuilder word){
        this.word = word;
        this.attempt = attempt;
        this.triedLetters = triedLetters;
    }
    
    public StringBuilder MakeDottedLine(){
        /* This function makes a dotted line(word) which is the same size as
        word */
        for (int i = 0; i < word.length(); i++){
            this.attempt.append('.');
        }
    }
    
    public void PlayHangman(){
        int tries = 0;
        char letterTry;
        Scanner scan = new Scanner(System.in);
        boolean notFinished = true;
        while (tries < 10 || notFinished){
            System.out.println("Enter a letter and press enter to try it.");
            letterTry = scan.next().charAt(0);
            
            notFinished = !WordFinished();
            tries++;    
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
        for (int i = 0; i < triedLetters.length(); i++){
            if (triedLetters.charAt(i) == letter){
            System.out.println("This letter has already been tried");
            return this.attempt;
            }
        }
        for (int i = 0; i < word.length(); i++){
            char test = word.charAt(i);
            if (test == letter){
                this.attempt = this.attempt.replace(i, i + 1, bufferattempt);
            }
        }
        this.triedLetters.append(letter);
        return this.attempt;
    }
}
