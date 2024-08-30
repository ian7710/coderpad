package TreesAndGraphs;

import java.util.*;

public class GraphTraversalBreadthFirstSearch {

    // Class representing a graph using adjacency list representation
    static class Graph {
        private int vertices; // Number of vertices
        private LinkedList<Integer>[] adjacencyList; // Adjacency list

        // Constructor to create a graph
        Graph(int v) {
            vertices = v;
            adjacencyList = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adjacencyList[v].add(w); // Add w to v's list
        }

        // Function to perform BFS starting from a given vertex
        void BFS(int s) {
            // Mark all the vertices as not visited
            boolean[] visited = new boolean[vertices];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<>();

            // Mark the current node as visited and enqueue it
            visited[s] = true;
            queue.add(s);

            while (!queue.isEmpty()) {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                System.out.print(s + " ");

                // Get all adjacent vertices of the dequeued vertex s
                // If an adjacent has not been visited, mark it visited and enqueue it
                for (int n : adjacencyList[s]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage for BFS
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("\nBreadth First Traversal (starting from vertex 2):");
        graph.BFS(2);
    }
}

