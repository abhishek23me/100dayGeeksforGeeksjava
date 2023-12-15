public class Day22 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int result = solution.minStep(10);

        // Print the result
        System.out.println("Minimum steps for n=10: " + result);
    }
}

class Solution {
    public int minStep(int n) {
        int c = 0;
        while (n != 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                n--;
            }
            c++;
        }
        return c;
    }
}
