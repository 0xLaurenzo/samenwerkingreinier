/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14;


/**
 *
 * @author Laurens
 * 
 */
public class TaskManager {
    private Buffer buf;
    private Buffer output;
    
    public TaskManager() {
        this.buf = new Buffer(2);
        this.output = new Buffer(10);
        
    }
    
    public void start() {
        
        IntGenerator gen = new IntGenerator(this.buf);
        BufferPrinter printer = new BufferPrinter(this.output);
        Thread t1 = new Thread(gen);
        Thread t3 = new Thread(printer);
        t1.start();
        t3.start();
        Sieve sieve = new Sieve(2, this.buf, this.output);
        Thread t = new Thread(sieve);
        t.start();
    }
    
    public void addSieve(int toFilter) {
        
    }
}
