package GraphTheory;

public class Main {
    public static void main(String[] args) {
        int[][] graphMatrix = {
                {0, 9, 6, 5, 3},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 4, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        Graph graph = new Graph(graphMatrix);
        graph.dijkstra(0);
    }
}
