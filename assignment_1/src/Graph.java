
import java.io.*;
import java.util.*;

public class Graph {

    int vertices;
    int edges;
    ArrayList<ArrayList<Object>> adjList = new ArrayList<ArrayList<Object>>();

    public void findVertices(String v) {
        vertices = Integer.parseInt(v);
        for (int i = 0; i < vertices; i++) {
            ArrayList<Object> babyList = new ArrayList<Object>();
            adjList.add(babyList);
        }
    }

    public void addEdges(int vertex, int connect) {
        adjList.get(vertex).add(connect);
        adjList.get(connect).add(vertex);
    }

    public void dirAddEdges(int vertex, int connect) {
        adjList.get(vertex).add(connect);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "-->");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public Graph Transpose() {
        Graph g = new Graph();
        g.edges = edges;
        g.vertices = vertices;
        g.adjList = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < vertices; i++) {
            ArrayList<Object> babyList = new ArrayList<Object>();
            g.adjList.add(babyList);
        }
        int vertex;
        int connect;
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                vertex = i;
                connect = (Integer) adjList.get(i).get(j);
                g.adjList.get(connect).add(vertex);
            }
        }
        return g;
    }
}
