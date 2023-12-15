public class Day28 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage of countX method
        int L = 10;
        int R = 50;
        int X = 2;
        int result = solution.countX(L, R, X);
        System.out.println("Occurrences of digit " + X + " between " + L + " and " + R + ": " + result);
    }
}

class Solution {
    int countX(int L, int R, int X) {
        int count = 0;

        for (int num = L + 1; num < R; num++) {
            count += countDigitOccurrences(num, X);
        }

        return count;
    }

    private int countDigitOccurrences(int number, int digit) {
        int count = 0;

        while (number != 0) {
            if (number % 10 == digit) {
                count++;
            }
            number /= 10;
        }

        return count;
    }
}


