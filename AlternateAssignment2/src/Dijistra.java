
import java.io.*;
import java.util.*;

public class Dijistra {

    int distance[];
    Object parent[];
    Queue<Integer> Set;

    public Dijistra(Graph g, int s) {
        distance = new int[g.vertices];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        parent = new Object[g.vertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = null;
        }

        Set = new LinkedList<Integer>();
        distance[s] = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue = addQueue(g);
        while (!queue.isEmpty()) {
            int min = min(distance, queue);
            int u = queue.remove(min);
            Set.add(min);
            for (int i = 0; i < g.adjList.get(i).size(); i++) {
                int v = g.adjList.get(i).get(i).dest;
                if (v == Integer.MAX_VALUE || !queue.contains(v)) {
                    break;
                }
                int alt = distance[u] + g.weight(u, v);
                if (distance[v] > alt) {
                    distance[v] = alt;
                    parent[v] = u;
                }
            }
        }
        for (int i = 0; i < g.vertices; i++) {
            System.out.println((i) + "-->" + distance[i]);
        }
    }

    public LinkedList<Integer> addQueue(Graph g) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < g.vertices; i++) {
            queue.add(i);
        }
        return queue;
    }

    public int min(int a[], LinkedList<Integer> queue) {
        int min = a[queue.get(0)];
        int key = 0;
        for (int i = 1; i < queue.size(); i++) {
            if (a[queue.get(i)] < min) {
                min = a[queue.get(i)];
                key = i;
            }
        }
        return key;
    }
}
