import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> stack1; // Primary stack for enqueue
    Stack<Integer> stack2; // Secondary stack for dequeue

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println(data + " enqueued.");
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty!");
                return -1; // Indicating an empty queue
            }
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Pop from stack2
        return stack2.pop();
    }

    // Peek operation
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty!");
                return -1; // Indicating an empty queue
            }
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    // to display
    public void display() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Queue elements (FIFO order):");

        // Temporarily transfer stack1 to stack2 to maintain FIFO
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Print elements in stack2 (FIFO order)
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }

        // Restore stack2 to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Queue is empty: " + queue.isEmpty());

        queue.enqueue(40);
        System.out.println("Peek: " + queue.peek());
        queue.display();
    }
}
