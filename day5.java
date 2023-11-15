class Day5{
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();

        // Call the shortestCommonSupersequence function and print the result
        System.out.println(shortestCommonSupersequence(X, Y, m, n));
    }

    public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
        // Create a 2D array to store the dynamic programming values
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table using a bottom-up approach
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If either of the strings is empty, the length of the supersequence is the sum of lengths of the non-empty string
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                }
                // If the characters at the current positions in both strings are the same,
                // extend the supersequence without counting the common character twice
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // If the characters are different, consider the minimum length by either adding the character from X
                // or adding the character from Y to the supersequence
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The value at the bottom-right corner of the dp table represents the length of the shortest common supersequence
        return dp[m][n];
    }
}
