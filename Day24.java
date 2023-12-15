public class day24 {

    public static void main(String[] args) {
        // Example usage
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};

        int result1 = isRepresentingBST(arr1, arr1.length);
        int result2 = isRepresentingBST(arr2, arr2.length);

        System.out.println("Result for arr1: " + result1);
        System.out.println("Result for arr2: " + result2);
    }

    static int isRepresentingBST(int arr[], int N) {
        if (N == 0) {
            return 1;
        }
        
        for (int i = 0; i < N; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            if (leftChildIndex < N && arr[i] > arr[leftChildIndex]) {
                return 0;
            }

            if (rightChildIndex < N && arr[i] > arr[rightChildIndex]) {
                return 0;
            }
        }
        
        return 1;
    }
}

