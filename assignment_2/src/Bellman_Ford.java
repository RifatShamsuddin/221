
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
                int w= g.weight(u, v);
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }
       for(int i=0;i<distance.length;i++){
           System.out.println(i+"-->"+distance[i]);
       }
    }
}
