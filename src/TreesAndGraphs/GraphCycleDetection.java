package TreesAndGraphs;

import java.util.*;

public class GraphCycleDetection {

    // Function to detect a cycle in an undirected graph using DFS
    public boolean hasCycleUndirected(int numVertices, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[numVertices]; // Array to keep track of visited nodes

        // Check for a cycle in each component of the graph
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) { // If the node hasn't been visited yet
                if (dfsUndirected(i, -1, visited, adjList)) {
                    return true; // Cycle found
                }
            }
        }

        return false; // No cycle found
    }

    // Helper function to perform DFS for undirected graph
    private boolean dfsUndirected(int node, int parent, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true; // Mark the current node as visited

        // Explore all adjacent nodes
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                // Recur for the adjacent node
                if (dfsUndirected(neighbor, node, visited, adjList)) {
                    return true; // Cycle found
                }
            } else if (neighbor != parent) {
                // If an adjacent node is visited and it's not the parent, then there's a cycle
                return true;
            }
        }

        return false; // No cycle found in this path
    }

    // Example usage
    public static void main(String[] args) {
        GraphCycleDetection graph = new GraphCycleDetection();

        // Number of vertices in the graph
        int numVertices = 5;

        // Adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the undirected graph
        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(3).add(4);
        adjList.get(4).add(3);
        adjList.get(4).add(1); // This edge creates a cycle

        // Detect cycle in the undirected graph
        boolean hasCycle = graph.hasCycleUndirected(numVertices, adjList);
        System.out.println("Cycle detected in undirected graph: " + hasCycle);
    }
}

