class Solution
{
    long countWays(int n, int k)
    {
        if (n == 1)
            return k;

        long mod = (long) 1e9 + 7, same = 0, diff = k;

        for (int i = 2; i <= n; i++)
        {
            long prev = same;
            same = diff;
            diff = ((prev + same) * (k - 1)) % mod;
        }

        return (same + diff) % mod;
    }
}

public class Day36 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int n1 = 3, k1 = 2;
        long ways1 = solution.countWays(n1, k1);
        System.out.println("Ways to color " + n1 + " fences with " + k1 + " colors: " + ways1);

        int n2 = 4, k2 = 3;
        long ways2 = solution.countWays(n2, k2);
        System.out.println("Ways to color " + n2 + " fences with " + k2 + " colors: " + ways2);

        int n3 = 2, k3 = 5;
        long ways3 = solution.countWays(n3, k3);
        System.out.println("Ways to color " + n3 + " fences with " + k3 + " colors: " + ways3);
    }
}

