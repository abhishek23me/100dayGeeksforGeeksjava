public class Day17 {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();

        // Original array
        long[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr);

        // Shuffle the array using the Solution class method
        solution.shuffleArray(arr, n);

        System.out.println("\nShuffled Array:");
        printArray(arr);
    }

    private static void printArray(long[] arr) {
        for (long num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

