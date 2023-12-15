import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> am(List<Integer> list1, int n, int s) {
        list1.add(n);
        if (n == list1.get(0)) return list1;

        if (n <= 0) s = 1;
        if (s == 1) return am(list1, n + 5, 1);
        else return am(list1, n - 5, 0);
    }

    public List<Integer> pattern(int N) {
        List<Integer> lists = new ArrayList<>();
        lists.add(N);
        if (N <= 0) return lists;
        return am(lists, N - 5, 0);
    }
}

public class Day18 {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();

        // Input value for pattern method
        int N = 20;

        // Get and print the result
        List<Integer> result = solution.pattern(N);
        System.out.println(result);
    }
}

