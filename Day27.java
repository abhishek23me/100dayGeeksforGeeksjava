import java.util.Arrays;

public class Day27 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int[] arr = {1, 5, 8, 10};
        int n = arr.length;
        int k = 2;

        int minDiff = solution.getMinDiff(arr, n, k);
        System.out.println("Minimum Difference: " + minDiff);
    }
}

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[n - 1];
        int ans = max - min;

        for (int i = 1; i < n; i++) {
            int a = arr[i - 1] + k;
            int b = arr[i] - k;

            if (b < 0) {
                continue;
            }

            max = Math.max(arr[n - 1] - k, a);
            min = Math.min(arr[0] + k, b);
            ans = Math.min(ans, max - min);
        }

        return ans;
    }
}