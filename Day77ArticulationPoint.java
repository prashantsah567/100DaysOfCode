import java.util.*;
import java.util.LinkedList;

public class Day77ArticulationPoint {

    public static void main(String args[]) {
        System.out.println("Articulation points in first graph ");

        // Create a graph and add edges
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        // find and print articulation points
        g.AP();
    }
}

class Graph {
    private int V; // number of vertices
    private LinkedList<Integer> adj[]; // adjacency list representation
    int time = 0; // time variable for DFS traversal
    static final int NIL = -1; // Indicates a null or uninitialized value

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // function to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // since it's an undirected graph
    }

    // Main function to find articulation points
    void AP() {
        boolean visited[] = new boolean[V]; // keep track of visited vertices
        int disc[] = new int[V]; // Discovery time of vertices
        int low[] = new int[V]; // Low value of vertices
        int parent[] = new int[V]; // parent of vertices in DFS tree
        boolean ap[] = new boolean[V]; // To store articulation points
        // Initialize arrays
        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }
        // Call the recursive function to find articulation points
        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                APUtil(i, visited, disc, low, parent, ap);
        }
        // Print articulation points
        for (int i = 0; i < V; i++) {
            if (ap[i] == true)
                System.out.println(i + " ");
        }
    }

    // Recursive function to find articulation points
    void APUtil(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]) {
        int children = 0; // Count of children in DFS tree
        visited[u] = true;
        disc[u] = low[u] = ++time; // Initialize discovery time and low value for u

        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext()) {
            int v = i.next(); // v is current adjacent of u

            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                low[u] = Math.min(low[u], low[v]);

                // u is an articulation point in following cases
                if (parent[u] == NIL && children > 1)
                    ap[u] = true;
                if (parent[u] != NIL && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}