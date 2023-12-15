import java.util.HashSet;

public class Day32 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage of findsum method
        int[] arr1 = {4, 2, -3, 1, 6};
        int n1 = arr1.length;
        System.out.println("Does arr1 have a subarray with 0-sum? " + solution.findsum(arr1, n1));

        int[] arr2 = {4, 2, 0, 1, 6};
        int n2 = arr2.length;
        System.out.println("Does arr2 have a subarray with 0-sum? " + solution.findsum(arr2, n2));

        int[] arr3 = {-3, 2, 3, 1, 6};
        int n3 = arr3.length;
        System.out.println("Does arr3 have a subarray with 0-sum? " + solution.findsum(arr3, n3));
    }
}

class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[], int n) {
        // HashSet to store prefix sums
        HashSet<Integer> set = new HashSet<>();

        // Initialize prefix sum
        int prefixSum = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Add the current element to the prefix sum
            prefixSum += arr[i];

            // If the current prefix sum is 0 or it has been seen before,
            // then there is a subarray with sum 0
            if (prefixSum == 0 || set.contains(prefixSum)) {
                return true;
            }

            // Add the current prefix sum to the set
            set.add(prefixSum);
        }

        // If no subarray with sum 0 is found
        return false;
    }
}

