/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment11;

/**
 *
 * @author Laurens
 */
public class Model {
    private int curTime;
    private int totalTime;
    
    public Model(){
    }
    
    public int getTotalTime(){
        return totalTime;
    }
    
    public void setTotalTime(int newTotal){
        this.totalTime = newTotal;
    }
    
    public void setCurTime(int newTime){
        this.curTime = newTime;
    }
    
    public int getCurTime(){
        return this.curTime;
    }
    
    public void decrementcurTime(){
        this.curTime--;
    }
}
