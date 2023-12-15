import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    public static void Inorder(Node root, ArrayList<Integer> l) {
        if (root == null) {
            return;
        }
        Inorder(root.left, l);
        l.add(root.data);
        Inorder(root.right, l);
        return;
    }

    public static boolean isDeadNode(Node root, ArrayList<Integer> l) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (l.contains(root.data - 1) && l.contains(root.data + 1)) {
                return true;
            }
        }
        return isDeadNode(root.left, l) || isDeadNode(root.right, l);
    }

    public static boolean isDeadEnd(Node root) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        Inorder(root, l);
        return isDeadNode(root, l);
    }
}

public class Day23 {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);

        // Check if the BST has a dead end
        boolean isDeadEnd = Solution.isDeadEnd(root);

        if (isDeadEnd) {
            System.out.println("The BST has a dead end.");
        } else {
            System.out.println("The BST does not have a dead end.");
        }
    }
}

