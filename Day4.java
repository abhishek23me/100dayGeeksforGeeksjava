class Day4 {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "cdab";

        // Call the isRotated function and print the result
        System.out.println(isRotated(str1, str2));
    }

    public static boolean isRotated(String str1, String str2) {
        // Check if the lengths of the two strings are different
        if (str1.length() != str2.length()) {
            return false;
        }

        int len = str1.length();

        // If the length is less than 2, the strings are equal if they are the same, otherwise, they are not rotated versions
        if (len < 2) {
            return str1.equals(str2);
        }

        // Generate clockwise and anticlockwise rotations of str1
        String clockwiseRotation = str1.substring(len - 2) + str1.substring(0, len - 2);
        String anticlockwiseRotation = str1.substring(2) + str1.substring(0, 2);

        // Check if str2 is equal to either the clockwise or anticlockwise rotation of str1
        return str2.equals(clockwiseRotation) || str2.equals(anticlockwiseRotation);
    }
}

