import java.util.List;
import java.util.ArrayList;

public class Day21 {
    public static void main(String[] args) {
        // Example usage
        int V = 5; // Number of vertices

        // Create an array of ArrayList to represent the adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 1);

        // Create an instance of Solution
        Solution solution = new Solution();

        // Call the isEulerCircuit method
        int result = solution.isEulerCircuit(V, adj);

        // Print the result
        System.out.println("Graph has an Euler Circuit: " + (result == 2));
        System.out.println("Graph has an Euler Path: " + (result == 1));
        System.out.println("Graph does not have an Euler Circuit or Path: " + (result == 0));
    }

    // Utility method to add an edge to the adjacency list
    private static void addEdge(List<Integer>[] adj, int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
}

