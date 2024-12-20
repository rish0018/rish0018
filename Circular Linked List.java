class CircularLinkedList {
    Node last;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        last = null;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            last = newNode;
            last.next = last;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            last = newNode;
            last.next = last;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
    }

    public void insert(int data, int index) {
        if (index < 0) {
            System.out.println("Index out of bounds");
            return;
        }

        Node newNode = new Node(data);
        if (isEmpty()) {
            if (index == 0) {
                last = newNode;
                last.next = last;
            } else {
                System.out.println("Index out of bounds");
            }
            return;
        }

        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        Node current = last.next;
        for (int i = 0; i < index - 1 && current != last; i++) {
            current = current.next;
        }

        if (current == last && index != 1) {
            System.out.println("Index out of bounds");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == last) {
            last = newNode;
        }
    }

    public void deleteAtBeginning() {
        if (isEmpty()) {
            System.out.println("Underflow!");
            return;
        }
        Node temp = last.next;
        if (last == last.next) {
            last = null;
            return;
        }
        last.next = temp.next;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            System.out.println("Underflow!");
            return;
        }
        if (last == last.next) {
            last = null;
            return;
        }

        Node current = last.next;
        while (current.next != last) {
            current = current.next;
        }
        current.next = last.next;
        last = current;
    }

    public void delete(int index) {
        if (isEmpty()) {
            System.out.println("Underflow!");
            return;
        }

        if (index < 0) {
            System.out.println("Index out of bounds");
            return;
        }

        if (index == 0) {
            deleteAtBeginning();
            return;
        }

        Node current = last.next;
        for (int i = 0; i < index - 1 && current.next != last.next; i++) {
            current = current.next;
        }

        if (current.next == last.next) {
            System.out.println("Index out of bounds");
            return;
        }

        Node temp = current.next;
        current.next = temp.next;

        if (temp == last) {
            last = current;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty!!!");
            return;
        }

        Node current = last.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != last.next);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.insertAtEnd(40);
        list.insert(50, 2);
        list.display();
        list.deleteAtBeginning();
        list.display();
        list.deleteAtEnd();
        list.display();
        list.delete(1);
        list.display();
    }
}
