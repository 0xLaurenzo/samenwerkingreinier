/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment13;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Laurens
 */
public class MultiMergeSort implements Runnable {

    private HashMap<Integer, int[]> arrays;
    private int toGet;
    private MergeSort sorter;
    
    public MultiMergeSort(){
        this.toGet = 0;
        this.arrays = new HashMap<Integer, int[]>();
        this.sorter = new MergeSort();
    }
    
    public void multiMergeSort(int[] toSort) {
            if (toSort.length < 1000) {
                sorter.sort(toSort);
            } else {
                arrays.put(1, Arrays.copyOf(toSort, toSort.length / 2));
                arrays.put(2, Arrays.copyOfRange(toSort, toSort.length / 2, toSort.length));
                Thread t1 = new Thread();
                Thread t2 = new Thread();
                t1.start();
                toGet++;
                t2.start();
                sorter.sort(arrays.get(0));
                sorter.sort(arrays.get(1));
                try {
                    t1.join();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sorter.merge(arrays.get(0), arrays.get(1), toSort);
            }
    }

    @Override
    public void run() {
        sorter.sort(arrays.get(toGet));
    }
}
