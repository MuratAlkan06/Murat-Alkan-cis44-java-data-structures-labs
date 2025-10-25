public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > best) best = sum;
            }
        }
        return best;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int curr = arr[0];
        int best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            best = Math.max(best, curr);
        }
        return best;
    }
}
