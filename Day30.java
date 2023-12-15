public class Day30 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int[] arr1 = {2, 3, 5};
        int n1 = arr1.length;
        int result1 = solution.minNumber(arr1, n1);
        System.out.println("Minimum operations for array " + arrayToString(arr1) + ": " + result1);

        int[] arr2 = {4, 6, 10};
        int n2 = arr2.length;
        int result2 = solution.minNumber(arr2, n2);
        System.out.println("Minimum operations for array " + arrayToString(arr2) + ": " + result2);
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public int minNumber(int arr[], int N) {
        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        if (isPrime(sum)) {
            return 0;
        }

        for (int i = 0; i < 100; i++) {
            sum += 1;
            count++;

            if (isPrime(sum)) {
                return count;
            }
        }
        
        return count;
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}


