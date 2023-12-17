public class Day39 {
    int findMaxSum(int arr[], int n) {
        int prev_sum = 0;
        int curr_sum = 0;
        for(int i = 0; i < n; i++) {
            int temp = Math.max(prev_sum + arr[i], curr_sum);
            prev_sum = curr_sum;
            curr_sum = temp;
        }
        return curr_sum;
    }

    public static void main(String[] args) {
        Day39 solution = new Day39();

        // Example usage:
        int[] arr = {1, 2, 3, -2, 5};
        int n = arr.length;
        int maxSum = solution.findMaxSum(arr, n);

        System.out.println("Maximum Sum: " + maxSum);
    }
}
