
import java.io.*;
import java.util.*;

public class level_4 {

    public static void main(String[] args) {
        try {
            File fl = new File("L:\\Lab\\assignment_1\\src\\input_3.txt");
            Scanner sc = new Scanner(fl);
            Graph g1 = new Graph();

            String st = sc.nextLine();
            g1.findVertices(st);
            String cn = sc.nextLine();
            g1.edges = Integer.parseInt(cn);

            int p = 0;
            while (sc.hasNextLine()) {
                String st1 = sc.nextLine();
                String[] arr = new String[2];
                arr = st1.split(" ");

                int vertex = Integer.parseInt(arr[0]);
                int connect = Integer.parseInt(arr[1]);
                g1.dirAddEdges(vertex, connect);
                p++;
                if (p == g1.edges) {
                    break;
                }
            }
            DFS d = new DFS(g1);
            d.DFS_LastPrint();
        } catch (Exception E) {
        }
    }
}
