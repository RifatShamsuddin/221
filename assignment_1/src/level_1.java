
import java.io.*;
import java.util.*;

public class level_1 {

    public static void main(String[] args) {
        try {
            //Using Scanner to read the given text file
            File fl = new File("L:\\Lab\\assignment_1\\src\\input.txt");
            Scanner sc = new Scanner(fl);
            //The graph class is the adjacency List with couple of more methods
            Graph g1 = new Graph();
            //Since the first line tells the number of vertices
            String st = sc.nextLine();
            g1.findVertices(st);
            //Since the second line contains the number of edges or connections there is
            String cn = sc.nextLine();
            g1.edges = Integer.parseInt(cn);

            //here using p as a counter to stop after finding the number of edges
            //We can also use a loop here but i realized the problem later so decided to use p
            int p = 0;
            while (sc.hasNextLine()) {
                //the next line of string contains the vertex and which 
                //other vertex that is connected with it
                String st1 = sc.nextLine();
                String[] arr = new String[2];
                arr = st1.split(" ");

                int vertex = Integer.parseInt(arr[0]);
                int connect = Integer.parseInt(arr[1]);
                g1.addEdges(vertex, connect);
                p++;
                if (p == g1.edges) {
                    break;
                }
            }
            String s = sc.nextLine();
            int t = Integer.parseInt(s);

            BFS b1 = new BFS(g1, 0);
            b1.printLevel(t);
        } catch (Exception E) {
        }
    }
}
