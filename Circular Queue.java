import java.util.Scanner;

class CircularQueue {
    private int[] queue; 
    private int front;   
    private int rear;    
    private int size;    

    // Constructor
    public CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Enqueue operation
    public void enqueue(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full!");
            return;
        }
        if (front == -1) { // First element to be inserted
            front = 0;
        }
        rear = (rear + 1) % size; // Circular increment
        queue[rear] = data;
        System.out.println(data + " enqueued.");
    }

    // Dequeue operation
    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int data = queue[front];
        if (front == rear) { // Queue becomes empty
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size; // Circular increment
        }
        return data;
    }

    // Peek operation
    public int peek() {
        if (front == -1) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Display the queue elements
    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the circular queue: ");
        int size = sc.nextInt();
        CircularQueue queue = new CircularQueue(size);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter the element to enqueue: ");
                int data = sc.nextInt();
                queue.enqueue(data);
            } else if (choice == 2) {
                int removed = queue.dequeue();
                if (removed != -1) {
                    System.out.println("Dequeued: " + removed);
                }
            } else if (choice == 3) {
                int front = queue.peek();
                if (front != -1) {
                    System.out.println("Front element: " + front);
                }
            } else if (choice == 4) {
                queue.display();
            } else if (choice == 5) {
                exit = true;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
