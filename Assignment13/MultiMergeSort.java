package assignment.pkg13;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
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
