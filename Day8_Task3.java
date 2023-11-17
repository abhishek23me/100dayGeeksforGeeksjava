public class Day8_Task3 {
    
    public static void main(String[] args) {
        int[] exampleArray = {1, 2, 4, 6, 3, 7, 8};
        int totalElements = 8;

        // Find and print the missing number
        int missingNum = missingNumber(exampleArray, totalElements);
        System.out.println(missingNum);
    }

    public static int missingNumber(int array[], int n) {
        // Calculate the expected sum using the formula (n * (n + 1)) / 2
        int expectedSum = (n * (n + 1)) / 2;

        // Calculate the actual sum of the elements in the array
        int actualSum = 0;
        for (int num : array) {
            actualSum += num;
        }

        // The missing number is the difference between the expected and actual sums
        return expectedSum - actualSum;
    }
}