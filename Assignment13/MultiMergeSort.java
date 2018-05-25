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

    private int[] array;
    
    public MultiMergeSort(int[] array){
        this.array = array;
    }
    
    public int[] getArray() {
        return this.array;
    }
    
    @Override
    public void run() {
        MergeSort.sort(array);
    }
}
