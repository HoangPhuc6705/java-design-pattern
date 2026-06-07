package GraphTheory;


public record Node(int dest, int weight) implements Comparable<Node> {
    @Override
    public int compareTo(Node o) {
        return Integer.compare(dest, o.dest);
    }
}
