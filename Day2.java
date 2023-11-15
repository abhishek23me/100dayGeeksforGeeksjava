class Day2 {

     public static void main(String[] args) {
        String pattern = "IDID";
        String output = printMinNumberForPattern(pattern);

        // Print the result
        System.out.println(output);
    }

    public static String printMinNumberForPattern(String pattern) {
        // Determine the length of the result array
        int n = pattern.length() + 1;

        // Initialize the result array with increasing order
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }

        // Process the pattern to generate the minimum number
        for (int i = 0; i < n - 1; i++) {
            // If 'D' is encountered, reverse the sequence of numbers
            if (pattern.charAt(i) == 'D') {
                int start = i;
                while (i < n - 1 && pattern.charAt(i) == 'D') {
                    i++;
                }
                reverse(result, start, i);
            }
        }

        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }

        return sb.toString();
    }

    //
    private static void reverse(int[] arr, int start, int end) {
        // Swap elements from the start and end towards the center until start is not less than end
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        // Move the indices towards the center
        start++;
        end--;
    }
    }
}
