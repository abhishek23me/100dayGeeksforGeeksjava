class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }

        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return (left.data == right.data)
                && isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);
    }
}

public class Day14 {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        // Check if the tree is symmetric
        boolean isSymmetric = GfG.isSymmetric(root);

        if (isSymmetric) {
            System.out.println("The tree is symmetric.");
        } else {
            System.out.println("The tree is not symmetric.");
        }
    }
}

