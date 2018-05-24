package assignment.pkg13;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class Sort {

    private static int arrayLength = 999;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array;
        array = new int[arrayLength];
        MergeSort mergeSort = new MergeSort();
        mergeSort.randomize(array);
        long timeStart = System.currentTimeMillis();
        mergeSort.multiSort(array);
        long timeEnd = System.currentTimeMillis();
        long timeDif = timeEnd - timeStart;
        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Took: " + timeDif + " millisecond(s), using " + numCores + " processors.");
    }
}