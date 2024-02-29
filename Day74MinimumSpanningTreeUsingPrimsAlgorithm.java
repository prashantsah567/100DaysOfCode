import java.util.Arrays;

public class Day74MinimumSpanningTreeUsingPrimsAlgorithm {
    static final int V = 4;// number of vertices

    public static int primMST(int graph[][]) {
        int[] key = new int[V];// array to store the minimum weight of its corresponding edges
        int res = 0;
        Arrays.fill(key, Integer.MAX_VALUE);// initialize key values as INFINITE
        boolean[] mSet = new boolean[V];// mSet[i] will be true if vertex i is included in MST
        key[0] = 0;// make key 0 so that this vertex is picked as the first vertex
        // MST will have V vertices
        for (int count = 0; count < V; count++) {
            int u = -1;// pick the minimum key vertex from the set of vertices not yet included in MST
            for (int i = 0; i < V; i++) {
                if (!mSet[i] && (u == -1 || key[i] < key[u]))
                    u = i;
            }
            // add the picked vertex to the MST
            mSet[u] = true;
            res += key[u];

            // update key value and parent index of the adjacent vertices of the picked
            // vertex
            // consider only those vertices which are not yet included in MST
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non-zero only for adjacent vertices of m
                // mSet[v] is false for vertices not yet included in MST
                // update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mSet[v] == false)
                    key[v] = Math.min(key[v], graph[u][v]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 5, 8, 0 }, { 5, 0, 10, 15 }, { 8, 10, 0, 20 }, { 0, 15, 20, 0 } };
        System.out.println(primMST(graph));
    }
}
