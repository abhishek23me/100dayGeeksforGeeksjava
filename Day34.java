class Solution {
    static int maxGold(int n, int m, int M[][]) {
        int[][] dp = new int[n][m];

        // Copy the values from the last column of M to the dp array
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = M[i][m - 1];
        }

        // Iterate through columns in reverse order
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int up = (i - 1 >= 0) ? dp[i - 1][j + 1] : 0;
                int down = (i + 1 < n) ? dp[i + 1][j + 1] : 0;
                int right = dp[i][j + 1];

                // Update dp array for the current cell
                dp[i][j] = M[i][j] + Math.max(right, Math.max(up, down));
            }
        }

        // Find the maximum value in the first column of dp array
        int maxGold = dp[0][0];
        for (int i = 1; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }
}

public class Day34 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int n = 4;
        int m = 4;
        int[][] M = {
            {1, 3, 3, 2},
            {2, 1, 4, 1},
            {0, 6, 4, 7},
            {5, 4, 2, 3}
        };

        int result = solution.maxGold(n, m, M);
        System.out.println("Maximum Gold Collected: " + result);
    }
}

