class Day1 {

    public static void main(String[] args) {
        // Example usage:
        int[][] array = {
            {1, 0, 1},
            {0, 0, 1},
            {1, 1, 0}
        };
        int N = 3;

        // Call the columnWithMaxZeros function and print the result
        int result = columnWithMaxZeros(array, N);
        System.out.println(result);
    }
    
    static int columnWithMaxZeros(int arr[][], int N) {
        // Initialize variables to track the maximum number of zeros and the corresponding column index
        int maxZeros = 0;
        int maxZerosColumn = -1;
        boolean foundZero = false; // Flag to indicate if any zero is found in the array

        // Iterate through each column
        for (int j = 0; j < N; j++) {
            int zerosInColumn = 0;

            // Iterate through each row in the current column
            for (int i = 0; i < N; i++) {
                // If the element is zero, increment the count of zeros in the column
                if (arr[i][j] == 0) {
                    zerosInColumn++;
                    foundZero = true; // Set the flag to true if a zero is found
                }
            }

            // Update the maximum zeros and corresponding column index if applicable
            if (zerosInColumn > maxZeros) {
                maxZeros = zerosInColumn;
                maxZerosColumn = j;
            }
        }

        // If any zero is found, return the index of the column with the maximum zeros
        // Otherwise, return -1 indicating that there are no zeros in the array
        return foundZero ? maxZerosColumn : -1;
    }

}

