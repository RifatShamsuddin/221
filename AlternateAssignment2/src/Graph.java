
import java.io.*;
import java.util.*;

public class Graph {

    int vertices;
    int edges;
     ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();

    public Graph(String v) {
        vertices = Integer.parseInt(v);
        for (int i = 0; i < vertices; i++) {
            ArrayList<Edge> babyList = new ArrayList<Edge>();
            adjList.add(babyList);
        }
    }

    public void addEdges(int vertex, int connect, int weight) {
        Edge edge = new Edge(vertex, connect, weight);
        adjList.get(vertex).add(edge);
    }

    public void addEdges(String vertex, String connect, String weight) {
        int vrtx=Integer.parseInt(vertex);
        int con=Integer.parseInt(connect);
        int wgh=Integer.parseInt(weight);
        Edge edge = new Edge(vrtx, con, wgh);
        adjList.get(vrtx).add(edge);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "-->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                
                Edge edge= adjList.get(i).get(j);
                edge.printEdge();
            }
            System.out.println();
        }
    }

    public int weight(int u, int v) {
        int w = 0;
        for (int j = 0; j < adjList.get(u).size(); j++) {
            Edge edge=adjList.get(u).get(j);
            if (edge.dest == v) {
                w = edge.weight;
            }
        }
        return w;
    }
}
