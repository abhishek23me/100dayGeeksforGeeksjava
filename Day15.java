class Node {
    int data;
    int height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
        this.left = this.right = null;
    }
}

class Solution {
    public Node insertToAVL(Node node, int data) {
        // Perform standard BST insert
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertToAVL(node.left, data);
        } else if (data > node.data) {
            node.right = insertToAVL(node.right, data);
        } else {
            // Duplicate data not allowed
            return node;
        }

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor to check if rotation is needed
        int balance = getBalance(node);

        // Perform rotations if needed to balance the tree
        // Left Left Case
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // If the tree is balanced, return the unchanged node
        return node;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // Return new root
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return new root
        return y;
    }
}

public class Day15 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating an AVL tree for testing
        Node root = null;
        int[] values = {10, 20, 30, 40, 50, 25};

        for (int value : values) {
            root = solution.insertToAVL(root, value);
        }

        // Displaying the AVL tree
        System.out.println("AVL Tree after insertion:");
        printInorder(root);
    }

    // Helper function to print the inorder traversal of the tree
    private static void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }
}