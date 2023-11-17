class Day9_Task2 {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 1, 2, 3, 4, 5 };
        convertToWave(n, arr);
    }

    static void convertToWave(int n, int[] a) {
        // Temporary array to store the result
        int[] arr = new int[n];

        // Copy the last element of the original array to the last position of the
        // temporary array
        arr[n - 1] = a[n - 1];

        // Copy the remaining elements of the original array to the temporary array
        for (int i = 0; i < n; i++) {
            arr[i] = a[i];
        }

        // Rearrange the array into a wave-like pattern
        for (int i = 0; i < n - 1; i++) {
            // Swap adjacent elements to make the array wave-like
            a[i] = arr[i + 1];
            i++;
        }

        for (int j = 1; j < n; j++) {
            // Swap adjacent elements to make the array wave-like
            a[j] = arr[j - 1];
            j++;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
