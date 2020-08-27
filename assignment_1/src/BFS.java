
import java.io.*;
import java.util.*;

public class BFS {

    String color[];
    int parent[];
    int levels[];

    BFS(Graph g, int s) {
        color = new String[g.vertices];
        for (int i = 0; i < color.length; i++) {
            color[i] = "W";
        }
        levels = new int[g.vertices];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = -1;
        }
        parent = new int[g.vertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        bfs_visit(g, s);
    }

    public void bfs_visit(Graph g, int s) {
        color[s] = "G";
        parent[s] = -1;
        levels[s] = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 0; i < g.adjList.get(u).size(); i++) {
                int v = (Integer) (g.adjList.get(u).get(i));
                if ("W".equals(color[v])) {
                    color[v] = "G";
                    levels[v] = levels[u] + 1;
                    parent[v] = u;
                    queue.add(v);
                }
            }
            color[u] = "B";
        }
    }

    //Prints the levels of all the nodes
    void printLevel() {
        for (int i = 0; i < levels.length; i++) {
            System.out.println(i + "=" + levels[i]);
        }
    }

    //Prints the level of specific node
    void printLevel(int s) {
        System.out.println(levels[s]);
    }

    //Finds the level of specific node
    int findLevel(int s) {
        return levels[s];
    }

    void printLowLevel(int s[]) {
        int j = 0;
        int low = Integer.MAX_VALUE;
        int k = -1;
        for (int i = 0; i < levels.length; i++) {
            if (s[j] == i) {
                if (low >= levels[i]) {
                    low = levels[i];
                    k = s[j];
                }
                j++;
                if (j == s.length) {
                    System.out.println(low);
                    break;
                }
            }
        }
    }
}
