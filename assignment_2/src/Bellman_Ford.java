
import java.io.*;
import java.util.*;

public class Bellman_Ford {

    int distance[];
    Object parent[];

    public Bellman_Ford(Graph g, int s) {
        distance = new int[g.vertices];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        parent = new Object[g.vertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = null;
        }
        distance[s] = 0;
        for (int i = 0; i < g.vertices - 1; i++) {
            for (int j = 0; j < g.adjList[i].size(); j++) {
                int u = g.adjList[i].get(j).src;
                int v = g.adjList[i].get(j).dest;
                int w = g.weight(u, v);
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(i + "-->" + distance[i]);
            System.out.println();
        }
    }

    public void printResult(Bellman_Ford bf, int s, int d) {
        if (bf.distance[d] == Integer.MAX_VALUE) {
            System.out.println("Be seeing ya, John");
            return;
        }
        int i = d;
        System.out.print((i) + "-->");
        while ((int) parent[i] != s) {
            i = (int) parent[i];
            System.out.print((i) + "-->");
        }
        i = s;
        System.out.print(i);
        System.out.println();
    }
}
