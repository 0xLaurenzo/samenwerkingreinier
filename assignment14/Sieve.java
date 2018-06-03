/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment14;
/*
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class Sieve implements Runnable {
    private Buffer buf;
    private Buffer output;
    private int toFilter;
    
    public Sieve(int toFilter, Buffer buf, Buffer output){
        this.buf = buf;
        this.output = output;
        this.toFilter = toFilter;
    }

    public int Filter(){
        boolean isPrime[] = new boolean[toFilter+1];
        for(int i = 0; i < toFilter; i++)
            isPrime[i] = true;
        for(int i = 2; i*i <= toFilter; i++){
            if(isPrime[i]){
                for(int j = i*2; j <= toFilter; j += i)
                    isPrime[j] = false;
            }
        }
        for(int i = 2; i <= toFilter; i++){
            if(isPrime[i])
                return i;
        }
        return 0;
    }
    
    @Override
    public void run() {
        Filter();
    }
}
