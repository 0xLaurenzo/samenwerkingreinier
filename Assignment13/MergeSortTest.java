package assignment.pkg13;

import java.util.Random;

/**
 * @author Reinier Sanders  s4335422
 * @author Laurens Kubat    s4626249
 */
public class MergeSortTest {
    
    public static void main(String[] args) {
        Random random = new Random();
        int[] data = new int[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(10000);
        }
        MergeSort sort = new MergeSort();
        long timeStart = System.currentTimeMillis();
        sort.multiMergeSort(data);
        long timeEnd = System.currentTimeMillis();
        long timeDif = timeEnd - timeStart;
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        System.out.println();
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Array sorted in " + timeDif + " milliseconds, using " + processors + " processors.");
    }
}
