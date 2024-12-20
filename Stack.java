import java.util.*;
class Stack{
    //stack using linked list 
    class Node {
        int data ; 
        Node next ;
        public Node (int data){
            this.data= data;
            this.next=null;
        }
    }
    Node top; 
    // to check if stack is empty
    public boolean isEmpty(){
        return top ==null ;
    }
    //to insert a node in the beginning 
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    public void pop (){
        if(isEmpty()){
            System.out.println("Underflow condition !");
            return;
        }
        top=top.next;
    }
    public void peek(){
        if(top==null){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("top is :"+top.data);
    }
    public void display(){
        if(top==null){
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        while(current!=null){
            System.out.println(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();
        stack.pop();
        stack.display();
    }
}