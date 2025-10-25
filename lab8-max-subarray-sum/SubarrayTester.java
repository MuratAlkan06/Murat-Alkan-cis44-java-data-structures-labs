import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            int[] data = generateRandomArrayWithNegatives(n);

            long t1 = System.nanoTime();
            int b = MaxSubarraySolver.bruteForceMaxSum(data);
            long t2 = System.nanoTime();
            System.out.println("Brute Force: " + ((t2 - t1) / 1_000_000.0) + " ms, max sum = " + b);

            long t3 = System.nanoTime();
            int k = MaxSubarraySolver.kadanesAlgorithmMaxSum(data);
            long t4 = System.nanoTime();
            System.out.println("Kadane's: " + ((t4 - t3) / 1_000_000.0) + " ms, max sum = " + k);
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        int[] arr = new int[size];
        Random r = new Random(42);
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(2001) - 1000; // [-1000, 1000]
        }
        return arr;
    }
}
