import java.util.*;

public class Day97RerouteToCityZero {
    public static int minReorder(int n, int[][] connections) {
        // create an adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges to the graph
        for (int[] connection : connections) {
            // outgoing edge from city ai to city bi
            graph.get(connection[0]).add(connection[1]);
            // incoming edge from city bi to city ai (represented by negative value)
            graph.get(connection[1]).add(-connection[0]);
        }

        // call the DFS method from city 0
        return dfs(graph, new boolean[n], 0);
    }

    private static int dfs(List<List<Integer>> graph, boolean[] visited, int city) {
        // initialize the change count for the city
        int change = 0;
        // mark the current city as visited
        visited[city] = true;

        // traverse all neighboring cities
        for (int next : graph.get(city)) {
            // if the neighboring city has not been visited
            if (!visited[Math.abs(next)]) {
                // recursively call DFS on the neighboring city
                // increment change by 1 if the edge is outgoing (next > 0)
                change += dfs(graph, visited, Math.abs(next)) + (next > 0 ? 1 : 0);
            }
        }

        // return the total change count for this city
        return change;
    }

    public static void main(String[] args) {
        int[][] connections = { { 1, 0 }, { 1, 2 }, { 3, 0 }, { 2, 4 } };

        System.out.println("The number of re-routes are: " + minReorder(5, connections));
    }
}
