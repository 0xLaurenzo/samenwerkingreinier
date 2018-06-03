/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14;
/*
 *
 *
 * @author Laurens
 *
 */
public class Sieve implements Runnable {
    private int toFilter;
    private Buffer buf;
    private Buffer output;
    
    public Sieve(int toFilter, Buffer buf, Buffer output) {
        this.toFilter = toFilter;
        this.buf = buf;
        this.output = output;
    }
    
    public void Filter() {
        while (true) {
            if (!buf.isEmpty()) {
                int intbuf = buf.get();
                if (intbuf%toFilter != 0) {
                    if (!output.isFull()) {
                        output.put(intbuf);
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        Filter();
    }
    
}

