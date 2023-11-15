import java.util.HashMap;

class Day3 {
    public static void main(String[] args) {
        String str1 = "egg";
        String str2 = "add";

        // Print the result of areIsomorphic function
        System.out.println(areIsomorphic(str1, str2));
    }

    // Function to check if two strings are isomorphic
    static boolean areIsomorphic(String str1, String str2) {
        // Check if the lengths of the two strings are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a HashMap to store the mapping between characters
        HashMap<Character, Character> map = new HashMap<>();

        // Iterate through each character in the strings
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            // If the character from str1 is already mapped, check if the mapping is consistent
            if (map.containsKey(char1)) {
                if (map.get(char1) != char2) {
                    return false; // Mapping conflict, strings are not isomorphic
                }
            } else {
                // If the character from str1 is not yet mapped, check if the character from str2 is already mapped
                if (map.containsValue(char2)) {
                    return false; // One-to-one mapping violation, strings are not isomorphic
                }
                // Add a new mapping for the current characters
                map.put(char1, char2);
            }
        }

        // If the loop completes, the strings are isomorphic
        return true;
    }
}
