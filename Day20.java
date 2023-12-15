import java.util.ArrayList;

class Solution {
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        int r = 0;
        for (int i = 0; i < V; i++) {
            r = r + adj.get(i).size();
        }
        return r;
    }
}

public class Day20 {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();

        // Creating an example adjacency list
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the adjacency list
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(3).add(4);

        // Calling the sumOfDependencies method
        int result = solution.sumOfDependencies(adj, V);

        // Printing the result
        System.out.println("Sum of Dependencies: " + result);
    }
}

