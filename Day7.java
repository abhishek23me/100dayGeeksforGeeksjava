import java.util.Arrays;

class Day7 {
    public static void main(String[] args) {
        // Example strings
        String str1 = "ljmolmti";
        String str2 = "sqapzwbb";
        
        // Print the better string based on the count of distinct subsequences
        System.out.println(betterString(str1, str2));
    }

    //   - the string with a higher count of distinct subsequences
    public static String betterString(String str1, String str2) {
        // Calculate the count of distinct subsequences for each input string
        int count1 = countDistinctSubsequences(str1);
        int count2 = countDistinctSubsequences(str2);

        // Compare the counts and return the string with the higher count
        if (count1 > count2) {
            return str1;
        } else if (count1 < count2) {
            return str2;
        } else {
            // If counts are equal, return the first string
            return str1;
        }
    }


    //   - the count of distinct subsequences for the entire string
    private static int countDistinctSubsequences(String str) {
        // Array to store the last occurrence of each character
        int[] lastOccurrence = new int[256];
        // Initialize the array with -1
        Arrays.fill(lastOccurrence, -1);

        // Modulo value to avoid integer overflow
        int mod = 1000000007;
        // Length of the input string
        int n = str.length();
        // Array to store the count of distinct subsequences for each prefix
        int[] dp = new int[n + 1];
        // Base case: there is one empty subsequence
        dp[0] = 1;

        // Loop through each character in the string
        for (int i = 1; i <= n; i++) {
            // Double the count for the current prefix
            dp[i] = (2 * dp[i - 1]) % mod;

            // If the current character has occurred before
            if (lastOccurrence[str.charAt(i - 1)] != -1) {
                // Subtract the count of subsequences without the current character
                dp[i] = (dp[i] - dp[lastOccurrence[str.charAt(i - 1)] - 1] + mod) % mod;
            }

            // Update the last occurrence index for the current character
            lastOccurrence[str.charAt(i - 1)] = i;
        }

        // Return the count of distinct subsequences for the entire string
        return dp[n];
    }
}
