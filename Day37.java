public class Day37 {
    public int nthPoint(int n) {
        int a = 1, b = 2;
        int mod = 1000000007;
        if (n < 3) {
            return n;
        }

        for (int i = 3; i <= n; i++) {
            int temp = a;
            a = b % mod;
            b = (temp + a) % mod;
        }
        return b;
    }

    public static void main(String[] args) {
        Day37 solution = new Day37();

        // Test the nthPoint method with different values of n
        int n1 = 5;
        int result1 = solution.nthPoint(n1);
        System.out.println("nthPoint(" + n1 + ") = " + result1);

        int n2 = 10;
        int result2 = solution.nthPoint(n2);
        System.out.println("nthPoint(" + n2 + ") = " + result2);

        // Add more test cases as needed
    }
}

