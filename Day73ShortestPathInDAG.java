import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Node class to represent each vertex in the graph
class Node {
    private int vertex;
    private int weight;

    Node(int v, int w) {
        vertex = v;
        weight = w;
    }

    int getVertex() {
        return vertex;
    }

    int getWeight() {
        return weight;
    }
}

// Graph class to represent the graph and perform topological sort
class Graph {
    private int V;
    private List<Node>[] adj;

    Graph(int v) {
        V = v;
        adj = new ArrayList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new ArrayList<>();
    }

    // Add directed edge from u to v with given weight
    void addEdge(int u, int v, int weight) {
        adj[u].add(new Node(v, weight));
    }

    // Perform topological sort on the graph
    Stack<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        return stack;
    }

    // Perform topological sort recursively
    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (Node node : adj[v]) {
            if (!visited[node.getVertex()]) {
                topologicalSortUtil(node.getVertex(), visited, stack);
            }
        }
        stack.push(v);
    }

    // Find shortest path from source vertex s to all other vertices
    void shortestPath(int s) {
        Stack<Integer> stack = topologicalSort();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);// initialize dist array with max integer value
        dist[s] = 0;// distace of s to itself is set to 0
        // main logic - where running a loop until stack is empty and each time we
        // checking if the current value is not max int value and its less than pervious
        // value then do the update of dist[node.getVertext()]
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Node node : adj[u]) {
                    if (dist[node.getVertex()] > dist[u] + node.getWeight()) {
                        dist[node.getVertex()] = dist[u] + node.getWeight();
                    }
                }
            }
        }
        // printing the result of shortest distance from s to each nodes
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
    }
}

// main class that generate the graph and then find the sortest distance
public class Day73ShortestPathInDAG {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(2, 3, 6);
        g.addEdge(5, 3, 1);

        int s = 0;
        System.out.println("Shortest distances from source " + s + ":");
        g.shortestPath(s);
    }
}
