import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {
    public static int countPairs(Node root1, Node root2, int x) {
        Set<Integer> list = new HashSet<>();

        preOrder(root1, list, x);

        int[] res = new int[1];
        countDiff(root2, list, res);
        return res[0];
    }

    private static void preOrder(Node node, Set<Integer> diff, int x) {
        if (node == null) return;

        diff.add(x - node.data);
        preOrder(node.left, diff, x);
        preOrder(node.right, diff, x);
    }

    private static void countDiff(Node node, Set<Integer> diff, int[] res) {
        if (node == null) return;

        if (diff.contains(node.data)) res[0]++;
        countDiff(node.left, diff, res);
        countDiff(node.right, diff, res);
    }
}

public class Day25 {
    public static void main(String[] args) {
        // Example usage
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(4);
        root2.left.right = new Node(8);

        int x = 10;

        int result = Solution.countPairs(root1, root2, x);
        System.out.println("Number of pairs with sum " + x + ": " + result);
    }
}

