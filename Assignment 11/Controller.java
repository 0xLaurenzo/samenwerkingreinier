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
public class Controller {
    private Model model;
    
    public Controller (Model model){
        this.model = model;
    }
    
    public int tickHandler(){
        model.decrementcurTime();
        return model.getCurTime();
    }
    
    
}
