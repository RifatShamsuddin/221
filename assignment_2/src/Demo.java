
import java.io.*;
import java.util.*;

public class Demo {

    public static void main(String args[]) {
        try {
            File fl = new File("N:\\New folder (3)\\221\\assignment_2\\src\\input.txt");
            Scanner sc = new Scanner(fl);
            String s = sc.nextLine();
            String arr[] = new String[4];
            arr = s.split(" ");
            //Taking number of vertices
            int vert = Integer.parseInt(arr[0]);
            //+1 since the given problem starts from 1 not 0
            vert = vert + 1;
            Graph g = new Graph(vert);
            //Taking number of edges
            g.edges = Integer.parseInt(arr[1]);
            //Taking number destination and number of cases
            int dest = Integer.parseInt(arr[2]);
            int cs = Integer.parseInt(arr[3]);
            for (int i = 0; i < g.edges; i++) {
                s = sc.nextLine();
                String arr1[] = new String[3];
                arr1 = s.split(" ");
                g.addEdges(arr1[0], arr1[1], arr1[2]);
            }
            String arr2[] = new String[2];
            for (int i = 0; i < cs; i++) {
                s = sc.nextLine();
                arr2 = s.split(" ");
                int src = Integer.parseInt(arr2[0]);
                int fdest = Integer.parseInt(arr2[1]);
                Dijistra b = new Dijistra(g, src, fdest);
                b.printResult(b, src, fdest);
            }
        } catch (Exception E) {
        }
    }
}
