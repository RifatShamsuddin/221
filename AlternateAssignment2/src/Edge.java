
import java.util.Comparator;


public class Edge implements Comparator<Node> {

    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public void printEdge() {
        System.out.print(dest + "/" + weight + " ");
    }

    public int compare(Edge e1, Edge e2) {
        if (e1.weight > e2.weight) {
            return 1;
        } else if (e1.weight < e2.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
