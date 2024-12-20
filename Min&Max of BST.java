class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a node into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Find the minimum value in the BST
    public int findMin() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return -1; // Indicate that the tree is empty
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // Find the maximum value in the BST
    public int findMax() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return -1; // Indicate that the tree is empty
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Find min and max
        System.out.println("Minimum value in BST: " + bst.findMin());
        System.out.println("Maximum value in BST: " + bst.findMax());
    }
}
