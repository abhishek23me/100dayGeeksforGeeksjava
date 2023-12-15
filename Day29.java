import java.util.ArrayList;

class Solution {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0, start = 0;
        for (int end = 0; end < n; end++) {
            sum += arr[end];
            while (sum > s)
                sum -= arr[start++];
            if (sum == s && start <= end) {
                res.add(start + 1);
                res.add(end + 1);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}

public class Day29 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int targetSum1 = 15;
        ArrayList<Integer> result1 = solution.subarraySum(arr1, arr1.length, targetSum1);
        printResult(arr1, targetSum1, result1);

        int[] arr2 = {5, 10, 20, 15};
        int targetSum2 = 45;
        ArrayList<Integer> result2 = solution.subarraySum(arr2, arr2.length, targetSum2);
        printResult(arr2, targetSum2, result2);

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int targetSum3 = 20;
        ArrayList<Integer> result3 = solution.subarraySum(arr3, arr3.length, targetSum3);
        printResult(arr3, targetSum3, result3);
    }

    private static void printResult(int[] arr, int targetSum, ArrayList<Integer> result) {
        System.out.println("Array: " + arrayToString(arr));
        System.out.println("Target Sum: " + targetSum);
        System.out.print("Result: ");
        if (result.get(0) == -1) {
            System.out.println("No subarray found.");
        } else {
            System.out.println("Subarray found from index " + result.get(0) + " to " + result.get(1));
        }
        System.out.println();
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}


