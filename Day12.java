class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {
    Node deleteNode(Node head, int x) {
        if (head == null) {
            return null;
        }

        if (x == 1) {
            return head.next;
        }

        Node current = head;
        Node prev = null;
        int count = 1;

        while (current != null && count < x) {
            prev = current;
            current = current.next;
            count++;
        }

        if (current == null) {
            return head;
        }

        prev.next = current.next;

        return head;
    }
}

public class Day12 {
    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Print original list
        System.out.println("Original List:");
        printList(head);

        // Delete node at position 3
        int positionToDelete = 3;
        GfG gfg = new GfG();
        Node newHead = gfg.deleteNode(head, positionToDelete);

        // Print modified list
        System.out.println("\nList after deleting node at position " + positionToDelete + ":");
        printList(newHead);
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

