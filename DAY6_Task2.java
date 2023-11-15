class Day6_Task2 {
    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 2, 8, 4, 6 };
        int x = 2;
        int y = 6;

        int result = minDist(array, array.length, x, y);
        //print output
        System.out.println(result);
    }

    static int minDist(int a[], int n, int x, int y) {
        // Initialize variables to store minimum distance, and indices of x and y.
        int minDistance = Integer.MAX_VALUE;
        int xIndex = -1;
        int yIndex = -1;

        // Iterate through the array to find indices of x and y, and update minDistance
        // accordingly.
        for (int i = 0; i < n; i++) {
            // Check if the current element is equal to x.
            if (a[i] == x) {
                xIndex = i;
                // If y has been found previously, update minDistance with the new distance.
                if (yIndex != -1) {
                    minDistance = Math.min(minDistance, Math.abs(xIndex - yIndex));
                }
            }
            // Check if the current element is equal to y.
            else if (a[i] == y) {
                yIndex = i;
                // If x has been found previously, update minDistance with the new distance.
                if (xIndex != -1) {
                    minDistance = Math.min(minDistance, Math.abs(yIndex - xIndex));
                }
            }
        }

        // If both x and y are present in the array, return the minimum distance.
        // Otherwise, return -1.
        return (xIndex != -1 && yIndex != -1) ? minDistance : -1;
    }
}
