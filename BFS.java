import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // For an undirected graph
    }

    // BFS Traversal
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Mark the starting node as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("BFS Traversal starting from vertex " + startVertex + ":");

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform BFS
        graph.BFS(0);
    }
}
