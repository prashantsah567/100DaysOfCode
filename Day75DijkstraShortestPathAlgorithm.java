import java.util.*;

public class Day75DijkstraShortestPathAlgorithm {
    public int[] dijkstra(List<List<Edge>> adjList, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(src, 0));

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();

            for (Edge edge : adjList.get(u.id)) {
                int alt = dist[u.id] + edge.weight;
                if (alt < dist[edge.to]) {
                    dist[edge.to] = alt;
                    pq.offer(new Vertex(edge.to, alt));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Edge>> adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        adjList.get(0).add(new Edge(0, 1, 5));
        adjList.get(0).add(new Edge(0, 2, 3));
        adjList.get(1).add(new Edge(1, 3, 6));
        adjList.get(1).add(new Edge(1, 4, 2));
        adjList.get(2).add(new Edge(2, 1, 1));
        adjList.get(2).add(new Edge(2, 3, 1));
        adjList.get(3).add(new Edge(3, 4, 4));

        Day75DijkstraShortestPathAlgorithm dijkstra = new Day75DijkstraShortestPathAlgorithm();
        int[] dist = dijkstra.dijkstra(adjList, V, 0);

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
}

class Vertex implements Comparable<Vertex> {
    int id;
    int dist;

    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    public int compareTo(Vertex other) {
        return Integer.compare(this.dist, other.dist);
    }
}

class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
