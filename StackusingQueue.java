class StackusingQueue {
    int[] stackArray;
    int top;
    // Constructor
    public StackusingQueue(int size) {
        stackArray = new int[size];
        top = -1; // Indicates an empty stack
    }

    // Push
    public void push(int data) {
        if (top == stackArray.length - 1) {
            System.out.println("Overflow!");
            return;
        }
        stackArray[++top] = data;
    }

    // Pop
    public void pop() {
        if (top == -1) {
            System.out.println("Underflow!");
            return;
        }
        top--;  
    }
    // Display
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
    // Main method
    public static void main(String args[]) {
        StackusingQueue stack = new StackusingQueue(5); // Specify size of stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display(); // Output: 50 40 30 20 10
        stack.pop();
        stack.display(); // Output: 40 30 20 10
    }
}
