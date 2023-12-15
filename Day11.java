class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Day11 {
    public static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                tail.next = new Node(head1.data);
                tail = tail.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        // Print original lists
        System.out.println("List 1:");
        printList(list1);
        System.out.println("List 2:");
        printList(list2);

        // Find and print the intersection
        Node intersection = findIntersection(list1, list2);
        System.out.println("\nIntersection List:");
        printList(intersection);
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

