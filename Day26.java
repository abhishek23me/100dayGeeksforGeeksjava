// User function Template for Java
class Solution {
    public String sumStrings(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int x = Character.getNumericValue(s1.charAt(i));
            int y = Character.getNumericValue(s2.charAt(j));
            int res = x + y + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            i--;
            j--;
        }

        while (i >= 0) {
            int x = Character.getNumericValue(s1.charAt(i));
            int res = x + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            i--;
        }

        while (j >= 0) {
            int y = Character.getNumericValue(s2.charAt(j));
            int res = y + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            j--;
        }

        while (carry > 0) {
            int rem = carry % 10;
            ans.append(rem);
            carry /= 10;
        }

        return ans.reverse().toString();
    }

    public boolean solve(String s, int pos, int l1, int l2) {
        String s1 = s.substring(pos, pos + l1);
        String s2 = s.substring(pos + l1, pos + l1 + l2);
        String s3 = sumStrings(s1, s2);
        int n = s3.length();

        if (n > s.length() - pos - l1 - l2) {
            return false;
        }

        if (s.substring(pos + l1 + l2, pos + l1 + l2 + n).equals(s3)) {
            if (pos + l1 + l2 + n == s.length()) {
                return true;
            }
            return solve(s, pos + l1, l2, n);
        }

        return false;
    }

    public int isSumString(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (solve(s, 0, i, j)) {
                    return 1;
                }
            }
        }
        return 0;
    }
}

public class Day26 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage of sumStrings method
        String num1 = "123";
        String num2 = "456";
        String sum = solution.sumStrings(num1, num2);
        System.out.println("Sum of " + num1 + " and " + num2 + ": " + sum);

        // Example usage of isSumString method
        String input1 = "112358";
        int result1 = solution.isSumString(input1);
        System.out.println("Is \"" + input1 + "\" a Sum String? " + (result1 == 1));

        String input2 = "199100199";
        int result2 = solution.isSumString(input2);
        System.out.println("Is \"" + input2 + "\" a Sum String? " + (result2 == 1));

        String input3 = "1235813";
        int result3 = solution.isSumString(input3);
        System.out.println("Is \"" + input3 + "\" a Sum String? " + (result3 == 1));
    }
}
