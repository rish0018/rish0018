class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at last
    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) { // Fixed loop condition
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at specific location
    public void insertAtLoc(int data, int val) {
        Node newNode = new Node(data);
        if (val == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        int count = 1;
        while (count < val && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete at start
    public void deleteStart() {
        if (head == null) {
            System.out.println("Underflow condition");
            return;
        }
        head = head.next;
    }

    // Delete at last
    public void deleteLast() {
        if (head == null) {
            System.out.println("Underflow condition!");
            return;
        }
        if (head.next == null) { // Handle single-node case
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete at specific index
    public void deleteSpec(int index) {
        if (head == null) {
            System.out.println("Underflow condition");
            return;
        }
        if (index < 0) {
            System.out.println("Index out of bounds!");
            return;
        }
        if (index == 0) { // Fixed indexing logic
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 1; i < index && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Out of bounds!");
            return;
        }
        current.next = current.next.next;
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = head; // Missing initialization
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(10);
        list.insertAtLast(20);
        list.insertAtLast(30);
        list.insertAtLoc(25, 2); // Insert at position 2
        list.display(); // 10 -> 20 -> 25 -> 30
        list.deleteLast();
        list.deleteStart();
        list.display(); // 20 -> 25
    }
}
