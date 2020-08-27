
import java.io.*;
import java.util.*;

public class Demo {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Graph g = new Graph(5);
        g.addEdges(1, 2, 4);
        g.addEdges(2, 3, 4);
        g.addEdges(1, 3, 20);
        g.addEdges(3, 4, 6);
        g.printGraph();
        
        Dijistra d = new Dijistra(g, 1);
        Bellman_Ford b = new Bellman_Ford(g, 1);
    }
}
