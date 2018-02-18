/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

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
            
    public Hangman(){
        wr = new WordReader("Words.txt");
        this.word = wr.getWord;
        this.attempt = attempt;
    }
    
    public Hangman(StringBuilder word){
        this.word = word;
        this.attempt = attempt;
    }
    
    public void PlayHangman(){
        int tries = 0;
        boolean finished = false;
        while (tries < word.length() || finished){
            
        }
    }
    
    public boolean WordFinished(){
        
        return false;
    }
    
    public StringBuilder TryLetter(char letter){
        for (int i = 0; i < word.length(); i++){
            char test = word.charAt(i);
            if (test == letter){
                
            }
        }
    }
}