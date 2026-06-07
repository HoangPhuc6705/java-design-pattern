package GraphTheory;

import java.util.*;

public class HashGraph {
    private Map<Integer, ArrayList<Node>> graph;
    private static final int INF = Integer.MAX_VALUE;
    public HashGraph() {
        graph = new HashMap<>();
    }

    public void addEdge(int source, int dest, int weight) {
        if (Objects.equals(source, dest))
            return;
        Node node = new Node(dest, weight);
        graph.computeIfAbsent(source, k -> new ArrayList<>()).add(node);
        Node node2 = new Node(source, weight);
        graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(node2);
    }

    public void removeEdge(int source, int dest) {
        graph.get(source).removeIf(k -> Objects.equals(k.dest(), dest));
        graph.get(dest).removeIf(k -> Objects.equals(k.dest(), source));
    }

    public void dijkstra(int source) {
        int size = graph.size();
        int[] dist = new int[size];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        boolean[] visited = new boolean[size];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();



    }

}


