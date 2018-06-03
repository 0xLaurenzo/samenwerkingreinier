/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14;

/**
 *
 * @author Laurens
 * TODO add a stop buffer and change while true to while(stop_buffer)
 */
public class Assignment14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        TaskManager manager = new TaskManager();
        manager.start();
        Thread.sleep(10000);
    }   
    
}
