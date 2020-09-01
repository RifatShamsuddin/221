
import java.io.*;
import java.util.*;

public class Dijistra {

    int distance[];
    Object parent[];
    Queue<Integer> Set;

    public Dijistra(Graph g, int s, int d) {
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
            if (distance[u] == Integer.MAX_VALUE) {
                break;
            }
            for (int i = 0; i < g.adjList[u].size(); i++) {
                int v = g.adjList[u].get(i).dest;
                if (!queue.contains(v)) {
                    break;
                }
                int alt = distance[u] + g.weight(u, v);
                if (distance[v] > alt) {
                    distance[v] = alt;
                    parent[v] = u;
                }
            }
        }
        System.out.println(distance[s]);
        
                int i=d;
        System.out.print(i+"-->");
        while((int)parent[i]!=s){
            i=(int)parent[i];
            System.out.print(i+"-->");
        }
        i=s;
        System.out.print(i);
        
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

    public Dijistra(Graph g, int s, int d, Queue<Integer> avoid) {
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
            if (distance[u] == Integer.MAX_VALUE || avoid.contains(u)) {
                continue;
            }
            for (int i = 0; i < g.adjList[u].size(); i++) {
                int v = g.adjList[u].get(i).dest;
                if (!queue.contains(v)) {
                    break;
                }
                int alt = distance[u] + g.weight(u, v);
                if (distance[v] > alt) {
                    distance[v] = alt;
                    parent[v] = u;
                }
            }
        }
        
//        for(int j=0;j<parent.length;j++){
//            System.out.println(j+"--"+parent[j]);
//        }

System.out.println(distance[d]);
        int i=d;
        System.out.print(i+"-->");
        while((int)parent[i]!=s){
            i=(int)parent[i];
            System.out.print(i+"-->");
        }
        i=s;
        System.out.print(i);
    }
}
