import java.util.*;

public class Day78BridgesInGraph {
    public static void main(String args[]) {
        System.out.println("Bridges in first graph ");
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        g.bridge(); // call the method to find bridges
    }
}

class Graph {
    private int V;// number of vertices

    private LinkedList<Integer> adj[]; // adjacency list to represent the graph
    int time = 0; // discovery time
    static final int NIL = -1; // constant for uninitialized value

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // method to add an edge between vertices v and u
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);// since its an undirected graph, add edge from w to v as well
    }

    // method to find bridges in the graph
    void bridge() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
        }

        // DFS traversal to find bridges
        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                bridgeUtil(i, visited, disc, low, parent);
        }
    }

    // DFS utility function to find bridges
    void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {
        visited[u] = true;
        disc[u] = low[u] = ++time; // set discovery and low time for vertex u

        Iterator<Integer> i = adj[u].iterator(); // to iterate over adjacent vertices

        while (i.hasNext()) {
            int v = i.next();

            if (!visited[v]) {// explore v, if haven't been visited
                parent[v] = u;// set u as parent of v
                bridgeUtil(v, visited, disc, low, parent);// recursively call bridgeUtil for v

                low[u] = Math.min(low[u], low[v]);// update low time of u based on low time of v

                // check for bridge condition: if low time of v if greater than discovery time
                // of u
                if (low[v] > disc[u])
                    System.out.println(u + " " + v);// print the bridge (u,v)
            } else if (v != parent[u])// if v has been visited and is not parent of u
                low[u] = Math.min(low[u], disc[v]);// update low time of u based on discovery time of v
        }
    }
}