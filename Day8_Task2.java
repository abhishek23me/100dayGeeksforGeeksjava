import java.util.HashSet;

public class Day8_Task2 {

    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        System.out.println(findString(n, k));
    }

    // Function to find the lexicographically smallest string of length 'n'
    // using characters from '0' to 'k' (inclusive)
    public static String findString(int n, int k) {
        // StringBuilder to store the result string
        StringBuilder ans = new StringBuilder();

        // Initialize the result string with '0' repeated 'n' times
        for (int i = 0; i < n; i++) {
            ans.append('0');
        }

        // Decrement 'k' for later use in the loop
        k--;

        // HashSet to keep track of visited strings to avoid duplicates
        HashSet<String> visited = new HashSet<>();
        visited.add(ans.toString());

        // Continue until all possible strings are generated
        while (visited.size() < Math.pow((k + 1), n)) {
            // Get the last 'n-1' characters from the current result string
            String previous = ans.substring(ans.length() - n + 1);

            // Iterate from 'k' to 0 to find the next character to append
            for (int i = k; i >= 0; i--) {
                // Form a new string by appending the current character to the previous substring
                String currStr = previous + (char) (i + '0');

                // If the new string is not visited, add it to the set and update the result string
                if (!visited.contains(currStr)) {
                    visited.add(currStr);
                    ans.append((char) (i + '0'));
                    break;
                }
            }
        }

        // Return the final result string
        return ans.toString();
    }
}
