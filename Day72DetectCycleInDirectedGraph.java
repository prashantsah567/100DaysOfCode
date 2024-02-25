import java.util.ArrayList;

public class Day72DetectCycleInDirectedGraph {
    // 2. Detect Cycle in a Directed graph
    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V]; // declare a boolean array to keep track of visited nodes (by default false)
        boolean[] recSt = new boolean[V]; // another boolean array to keep track of nodes in recursion stack
        // traverse the list and call DFSRec only if the node is not visited, and pass
        // an additional parameter of recSt
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (DFSRec(adj, i, visited, recSt) == true)
                    return true;
            }
        }
        return false;
    }

    private static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recSt) {
        // start with marking both the visited and recSt array as true
        visited[s] = true;
        recSt[s] = true;
        // traverse the list and recursively call DFSRec if the current node is not
        // visited
        for (int u : adj.get(s)) {
            if (visited[u] == false && DFSRec(adj, u, visited, recSt) == true) {
                return true;
            } else if (recSt[u] == true) {
                // otherwise, retrun true if the node is in recrusion stack and already visited
                return true;
            }
        }
        // at the end of one execution mark the node (s) as false
        recSt[s] = false;
        return false;// if no cycle found return false
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);

        if (detectCycle(adj, V) == true)
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
