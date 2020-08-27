
import java.io.*;
import java.util.*;

public class level_2 {

    public static void main(String[] args) {
        try {
            File fl = new File("L:\\Lab\\assignment_1\\src\\input_1.txt");
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
                g1.addEdges(vertex, connect);
                p++;
                if (p == g1.edges) {
                    break;
                }
            }
            String l = sc.nextLine();
            int lina = Integer.parseInt(l);

            l = sc.nextLine();
            int nora = Integer.parseInt(l);

            l = sc.nextLine();
            int lara = Integer.parseInt(l);

            BFS b = new BFS(g1, lina);

            if (b.findLevel(nora) < b.findLevel(lara)) {
                System.out.println("Nora");
            } else {
                System.out.println("Lara");
            }
        } catch (Exception E) {
        }
    }
}
