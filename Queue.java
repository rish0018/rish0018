class Queue {
    // Node class for the queue
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node rear, front;

    // Constructor to initialize both rear and front to null
    public Queue() {
        rear = front = null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue (add to the queue)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue (remove from the queue)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.display(); 
        queue.dequeue();
        queue.dequeue();
        queue.display();
    }
}
