import java.util.ArrayList;

public class Day72DetectCycleInUndirectedGraph {
    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V]; // declare a boolean array to keep track of visited nodes
        // traverse each vertices (nodes) and only call the DFSRec method if node is
        // already not visited with parent as -1 for the first pass
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (DFSRec(adj, i, visited, -1) == true)
                    return true;
            }
        }
        return false;
    }

    private static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true;// mark the source (current node) as true
        // traverse each element in the current list
        for (int u : adj.get(s)) {
            // if current node is already not visited then recursively call with
            // new source (s) and the updated parent
            if (visited[u] == false) {
                if (DFSRec(adj, u, visited, s) == true)
                    return true;
            } else if (u != parent)// otherwise if the node is already visited and not it's parent then return true
                return true;
        }
        return false;// in the end return false if no cycle found
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);

        if (detectCycle(adj, V) == true)
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
