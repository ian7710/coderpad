package TreesAndGraphs;

import java.util.*;

public class GraphTraversalDepthFirstSearch {

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

        // Function to perform DFS starting from a given vertex
        void DFS(int v) {
            // Mark all the vertices as not visited (set as false by default)
            boolean[] visited = new boolean[vertices];

            // Call the recursive helper function to perform DFS
            DFSUtil(v, visited);
        }

        // A recursive function to perform DFS starting from vertex v
        private void DFSUtil(int v, boolean[] visited) {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");

            // Recur for all the vertices adjacent to this vertex
            for (int n : adjacencyList[v]) {
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage for DFS
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth First Traversal (starting from vertex 2):");
        graph.DFS(2);
    }
}

