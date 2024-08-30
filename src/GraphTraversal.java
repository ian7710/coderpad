import java.util.*;

public class GraphTraversal {

    // Graph represented using an adjacency list
    static class Graph {
        private int vertices; // Number of vertices in the graph
        private LinkedList<Integer>[] adjList; // Adjacency list

        // Constructor to initialize the graph
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        // Function to add an edge to the graph
        void addEdge(int source, int destination) {
            adjList[source].add(destination);
        }

        // Depth-First Search (DFS) implementation
        void DFS(int startVertex) {
            boolean[] visited = new boolean[vertices]; // Array to track visited vertices
            DFSUtil(startVertex, visited); // Start DFS from the given vertex
        }

        // Utility function for DFS, implemented using recursion
        private void DFSUtil(int vertex, boolean[] visited) {
            visited[vertex] = true; // Mark the current vertex as visited
            System.out.print(vertex + " "); // Print the visited vertex

            // Recursively visit all the adjacent vertices
            for (int adjVertex : adjList[vertex]) {
                if (!visited[adjVertex]) {
                    DFSUtil(adjVertex, visited);
                }
            }
        }

        // Breadth-First Search (BFS) implementation
        void BFS(int startVertex) {
            boolean[] visited = new boolean[vertices]; // Array to track visited vertices
            LinkedList<Integer> queue = new LinkedList<>(); // Queue for BFS

            visited[startVertex] = true; // Mark the start vertex as visited
            queue.add(startVertex); // Enqueue the start vertex

            while (!queue.isEmpty()) {
                int vertex = queue.poll(); // Dequeue a vertex from the queue
                System.out.print(vertex + " "); // Print the visited vertex

                // Get all adjacent vertices of the dequeued vertex
                for (int adjVertex : adjList[vertex]) {
                    if (!visited[adjVertex]) {
                        visited[adjVertex] = true; // Mark the adjacent vertex as visited
                        queue.add(adjVertex); // Enqueue the adjacent vertex
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage of the graph and traversal methods
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("Depth-First Search (starting from vertex 0):");
        graph.DFS(0);

        System.out.println("\nBreadth-First Search (starting from vertex 0):");
        graph.BFS(0);
    }
}

