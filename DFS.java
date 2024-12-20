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

    // DFS Traversal (Recursive)
    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited nodes
        System.out.println("DFS Traversal starting from vertex " + startVertex + ":");
        DFSUtil(startVertex, visited);
    }

    // Utility function for DFS
    private void DFSUtil(int vertex, boolean[] visited) {
        // Mark the current vertex as visited
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Recur for all adjacent vertices
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
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

        // Perform DFS
        graph.DFS(0);
    }
}
