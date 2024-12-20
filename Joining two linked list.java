class LinkedList {
    // Node class representing each element in the list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head; // Head of the linked list

    // Add a node to the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) { // Traverse until the last node
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Concatenate another linked list to this one
    public void concatenate(LinkedList otherList) {
        if (head == null) { // If the first list is empty, set it to the second list
            head = otherList.head;
            return;
        }
        if (otherList.head == null) { // If the second list is empty, do nothing
            return;
        }
        Node temp = head;
        while (temp.next != null) { // Traverse to the last node of the first list
            temp = temp.next;
        }
        temp.next = otherList.head; // Point the last node to the head of the second list
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        // Adding elements to the first list
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        // Adding elements to the second list
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);

        // Display both lists
        System.out.println("List 1:");
        list1.display();
        System.out.println("List 2:");
        list2.display();

        // Concatenate list2 to list1
        list1.concatenate(list2);

        // Display the concatenated list
        System.out.println("Concatenated List:");
        list1.display();
    }
}
