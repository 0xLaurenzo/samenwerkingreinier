/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14;

/**
 *
 * @author Laurens
 */
public class IntGenerator implements Runnable{
    private Buffer buf;
    
    public IntGenerator(Buffer buf) {
        this.buf = buf;
    }
    
    public void StartGeneration () {
        int i = 2;
        while (i < 10000) {
            if (!buf.isFull()) {
                this.buf.put(i);
                i++;
            }
        }
    }

    @Override
    public void run() {
        StartGeneration();
    }
}
