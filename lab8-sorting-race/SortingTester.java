import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        
        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            int[] avg = generateRandomArray(n);
            runAndTimAllSorts("Average Case", avg);

            int[] best = generateSortedArray(n);
            runAndTimAllSorts("Best Case", best);

            int[] worst = generateReverseSortedArray(n);
            runAndTimAllSorts("Worst Case", worst);
        }
    }
    
    // TODO: Implement the runAndTimAllSorts helper method.
    public static void runAndTimAllSorts(String label, int[] base) {
        System.out.println(label + ":");
        int[] a1 = Arrays.copyOf(base, base.length);
        long t1 = System.nanoTime();
        SortingAlgorithms.selectionSort(a1);
        long t2 = System.nanoTime();
        System.out.println("  Selection Sort: " + ((t2 - t1) / 1_000_000.0) + " ms");

        int[] a2 = Arrays.copyOf(base, base.length);
        long t3 = System.nanoTime();
        SortingAlgorithms.insertionSort(a2);
        long t4 = System.nanoTime();
        System.out.println("  Insertion Sort: " + ((t4 - t3) / 1_000_000.0) + " ms");

        int[] a3 = Arrays.copyOf(base, base.length);
        long t5 = System.nanoTime();
        SortingAlgorithms.mergeSort(a3);
        long t6 = System.nanoTime();
        System.out.println("  Merge Sort: " + ((t6 - t5) / 1_000_000.0) + " ms");
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random r = new Random(42);
        for (int i = 0; i < size; i++) arr[i] = r.nextInt();
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - 1 - i;
        return arr;
    }
}
