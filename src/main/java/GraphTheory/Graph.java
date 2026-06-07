package GraphTheory;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

@Data
public class Graph {
    private int[][] matrix;


    public Graph(int size) {
        this.matrix = new int[size][size];

        for (int[] row : matrix) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

    }

    public Graph(int[][] matrix) {
        this.matrix = matrix;
    }

    public void addEdge(int x, int y, int w) {
        matrix[x][y] = w;
        matrix[y][x] = w;
    }

    public void removeEdge(int x, int y) {
        matrix[x][y] = Integer.MIN_VALUE;
        matrix[y][x] = Integer.MIN_VALUE;
    }

    public int degree(int v) {
        return (int) Arrays.stream(matrix[v]).filter(k -> !Objects.equals(k, Integer.MIN_VALUE)).count();
    }

    public int totalEdge() {
        int t = 0;
        for (int i = 0; i < matrix.length; ++i) {
            t += degree(i);
        }
        return t;
    }

    public void dijkstra(int source) {
        int size = matrix.length;
        int[] distances = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        boolean[] visited = new boolean[size];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            for (int v = 0; v < size; v++) {
                if (matrix[u][v] > 0 && !visited[v]) {
                    int w = matrix[u][v];
                    if (distances[u] + w < distances[v]) {
                        distances[v] = distances[u] + w;
                        pq.add(new Node(v, distances[v]));
                    }
                }
            }
        }

        System.out.println("Shorted distance from source " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            String str = (distances[i] == Integer.MAX_VALUE) ? "INF" : distances[i] + "";
            System.out.println(i + " " + str);
        }
    }

    @AllArgsConstructor
    public static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(distance, o.distance);
        }
    }

}
