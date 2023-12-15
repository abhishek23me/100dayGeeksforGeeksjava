class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Day10 {
    public static Node reverseDLL(Node head) {
        Node temp = head;

        while (temp != null) {
            Node t = temp.prev;
            temp.prev = temp.next;
            temp.next = t;
            temp = temp.prev;
        }

        if (head != null) {
            head = head.prev;
        }

        return head;
    }

    public static void main(String[] args) {
        // Example usage
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // Connect nodes
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;

        // Print original order
        System.out.println("Original Order:");
        printList(node1);

        // Reverse the doubly linked list
        Node reversedHead = reverseDLL(node1);

        // Print reversed order
        System.out.println("\nReversed Order:");
        printList(reversedHead);
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

