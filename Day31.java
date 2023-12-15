public class Day31 {
    static boolean isprime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int sumofdigit(int n) {
        int digsum = 0;
        int rem = 0;
        int y = n;
        while (y > 0) {
            rem = y % 10;
            digsum = digsum + rem;
            y = y / 10;
        }
        return digsum;
    }

    static int smithNum(int n) {
        int sum = 0;
        int digsum = 0;
        int y = 0;
        digsum = sumofdigit(n);

        for (int i = 2; i <= n; i++) {
            if (isprime(i)) {
                int x = n;
                while (x % i == 0) {
                    y = sumofdigit(i);
                    sum += y;
                    x = x / i;
                }
            }
        }

        if (sum == digsum && !isprime(n)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        // Example usage
        int num1 = 4;
        int result1 = smithNum(num1);
        System.out.println(num1 + " is a Smith number: " + (result1 == 1));

        int num2 = 22;
        int result2 = smithNum(num2);
        System.out.println(num2 + " is a Smith number: " + (result2 == 1));

        int num3 = 27;
        int result3 = smithNum(num3);
        System.out.println(num3 + " is a Smith number: " + (result3 == 1));

        // Additional Example
        int num4 = 378; // Replace with your desired number
        int result4 = smithNum(num4);
        System.out.println(num4 + " is a Smith number: " + (result4 == 1));
    }
}

