class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;


    public void deleteNode(int position) {
        if (head == null) {
            System.out.println("The list is empty. Deletion not possible.");
            return;
        }


        if (position == 0) {
            head = head.next;
            return;
        }


        Node current = head;
        Node prev = null;


        for (int i = 0; i < position && current.next != null; i++) {
            prev = current;
            current = current.next;
        }


        if (current.next == null) {
            if (prev != null) {
                prev.next = null;
            }
            return;
        }


        if (prev != null) {
            prev.next = current.next;
        } else {
            System.out.println("Position out of range.");
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);

        System.out.println("Original List:");
        list.display();

        System.out.println("Deleting node at position 1:");
        list.deleteNode(1);
        list.display();

        System.out.println("Deleting node at position 4:");
        list.deleteNode(4);
        list.display();

        System.out.println("Deleting the last node:");
        list.deleteNode(2);
        list.display();
    }
}
