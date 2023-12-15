public class Day35 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage of countStrings method
        int n = 5;
        long result = countStrings(n, solution);
        System.out.println("Number of binary strings of length " + n + ": " + result);

        // Add more test cases as needed
    }

    public static long countStrings(int n, Solution solution) {
        int MOD = 1000000007;
        long zero = 1;
        long one = 1;

        for (int i = 2; i <= n; i++) {
            long nZero = (zero + one) % MOD;
            long nOne = zero;

            zero = nZero;
            one = nOne;
        }

        return (int) (zero + one) % MOD;
    }
}

