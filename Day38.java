class Day38
{
    static long countStr(long n)
    {
        // code here
        return 1 + n + n + n * (n - 1) + n * (n - 1) / 2 + n * (n - 1) * (n - 2) / 2;
    }

    public static void main(String[] args)
    {
        // You can add test cases or other logic in the main method if needed
        long result = countStr(5); // Example: calling countStr with n = 5
        System.out.println("Result: " + result);
    }
}
