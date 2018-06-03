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
public class BufferPrinter implements Runnable {
    private Buffer buf;
    
    public BufferPrinter (Buffer buf) {
        this.buf = buf;
    }
    public void printBuffer() {
        while (true){
            System.out.println(this.buf.get());
        }
    }

    @Override
    public void run() {
        printBuffer();
    }
}
