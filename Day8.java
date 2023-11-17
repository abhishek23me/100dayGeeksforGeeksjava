import java.util.Arrays;

class Day8 {

    public static void main(String[] args) {
        // Test strings
        String str1 = "listen";
        String str2 = "silent";
        
        //print the output
        System.out.println(areAnagrams(str1, str2));
    }

    // Function to check if two strings are anagrams
    static boolean areAnagrams(String a, String b) {
        // Check if lengths of both strings are equal
        if (a.length() != b.length()) {
            return false;
        }

        // Convert strings to char arrays
        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();

        // Sort both char arrays
        Arrays.sort(charArrayA);
        Arrays.sort(charArrayB);

        // Compare sorted arrays
        return Arrays.equals(charArrayA, charArrayB);
    }
}
