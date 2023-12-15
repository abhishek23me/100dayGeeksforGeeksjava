#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    //Function to detect cycle using DSU in an undirected graph.

    int findPar(vector<int> &parent, int node)
    {
        if (parent[node] == node)
            return node;

        return parent[node] = findPar(parent, parent[node]);
    }

    bool unionSet(int i, int j, vector<int> &parent)
    {
        int u = findPar(parent, i);
        int v = findPar(parent, j);

        if (u != v)
        {
            parent[u] = v;
            return false;
        }

        return true;
    }

    int detectCycle(int V, vector<int> adj[])
    {
        // Code here
        vector<int> parent(V);
        for (int i = 0; i < V; i++)
        {
            parent[i] = i;
        }

        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < adj[i].size(); j++)
            {
                //i<adj[i][j] to handle case for 1->2 and 2->1 not considre as cycle
                if (i < adj[i][j] && unionSet(i, adj[i][j], parent))
                {
                    return 1;
                }
            }
        }

        return 0;
    }
};

class Day19
{
public:
    static void main()
    {
        // Example usage
        int V = 4;
        vector<int> adj[V];

        // Creating a cycle
        adj[0].push_back(1);
        adj[1].push_back(2);
        adj[2].push_back(3);
        adj[3].push_back(0);

        Solution sol;
        int cycleDetected = sol.detectCycle(V, adj);

        if (cycleDetected)
        {
            cout << "Cycle detected in the graph." << endl;
        }
        else
        {
            cout << "No cycle detected in the graph." << endl;
        }
    }
};

int main()
{
    // Run the main method of Day18 class
    Day18::main();

    return 0;
}

