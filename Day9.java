class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Day9 {

    public static void main(String[] args) {
        Day9 tree = new Day9();

        // Constructing the Binary Tree
        // 4
        // / \
        // 2 5
        // / \
        // 1 3
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        // Convert to CDLL
        tree.treeToDoublyList(tree.root);

        // Display the CDLL
        tree.displayy();
    }

    // Root of the Binary Tree
    Node root;
    Node head;
    Node prev;

    // Convert a binary tree to circular
    // doubly linked list
    void treeToDoublyList(Node root) {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        treeToDoublyList(root.left);

        // Convert this node
        if (prev == null) {
            // If prev is null, then this is the first node in inorder traversal,
            // so we set head to this node
            head = root;
        } else {
            // Otherwise, set the right of the previous node to the current node,
            // and set the left of the current node to the previous node
            root.left = prev;
            prev.right = root;
        }

        // Update the previous node to the current node
        prev = root;

        // Set head to the leftmost node during the first iteration
        if (head == null) {
            head = root;
        }

        // Recursively convert right subtree
        treeToDoublyList(root.right);
    }

    // Display the circular doubly linked list
    void displayy() {
        Node current = head;

        do {
            System.out.print(current.data + " ");
            current = current.right;
        } while (current != null && current != head);
    }
}
