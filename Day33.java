import java.util.ArrayList;

class Solution {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        long currSum = 0, maxSum = 0;
        if (K > N) {
            return -1;
        }
        for (int i = 0; i < K; i++) {
            currSum += Arr.get(i);
        }
        maxSum = currSum;
        for (int i = K; i < N; i++) {
            currSum = currSum - Arr.get(i - K) + Arr.get(i);
            // Update maxSum if the currentSum is greater
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

public class Day33 {
    public static void main(String[] args) {
        // Example usage of maximumSumSubarray method
        Solution solution = new Solution();

        // Create an ArrayList of integers
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        // Set the value of K (subarray length)
        int K = 3;

        // Call the maximumSumSubarray method and print the result
        long result = solution.maximumSumSubarray(K, arr, arr.size());
        System.out.println("Maximum sum of subarray of length " + K + ": " + result);
    }
}
