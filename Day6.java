class Day6 {
    // Function to check if two strings are rotations of each other or not.
    public static void main(String[] args) {
        String s1 = "GeeksforGeeks";
        String s2 = "forGeeksGeeks";
        System.out.println(areRotations(s1, s2));

    }

    static boolean areRotations(String s1, String s2) {
        // Your code here
        if (s1.length() != s2.length()) {
            return false;
        }

        // Concatenate s2 with itself
        String concatenated = s2 + s2;

        // Check if s1 is a substring of the concatenated string
        return concatenated.contains(s1);
    }
}