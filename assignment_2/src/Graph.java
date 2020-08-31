
import java.io.*;
import java.util.*;

public class Graph {

    int vertices;
    int edges;
    ArrayList<Edge>[] adjList;

    public Graph(String v) {
        vertices = Integer.parseInt(v);
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<Edge>();
        }
    }

    public Graph(int v) {
        vertices = v;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<Edge>();
        }
    }

    public void addEdges(String vertex, String connect, String weight) {
        int vert=Integer.parseInt(vertex);
        int conn=Integer.parseInt(connect);
        int wei=Integer.parseInt(weight);
        Edge edge = new Edge(vert, conn, wei);
        adjList[vert].add(edge);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "-->");
            for (int j = 0; j < adjList[i].size(); j++) {
                Edge edge = adjList[i].get(j);
                edge.printEdge();
            }
            System.out.println();
        }
    }

    public int weight(int u, int v) {
        int w = 0;
        for (int j = 0; j < adjList[u].size(); j++) {
            if (adjList[u].get(j).dest == v) {
                w = adjList[u].get(j).weight;
            }
        }
        return w;
    }
}
