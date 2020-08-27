
import java.io.*;
import java.util.*;

public class level_3 {

    public static void main(String[] args) {
        try {
            File fl = new File("L:\\Lab\\assignment_1\\src\\input_2.txt");
            Scanner sc = new Scanner(fl);
            Graph g1 = new Graph();

            String st = sc.nextLine();
            g1.findVertices(st);
            String cn = sc.nextLine();
            g1.edges = Integer.parseInt(cn);

            //Taking all the vertex and edges
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

            //Taking Linas postion
            String l = sc.nextLine();
            int lina = Integer.parseInt(l);

            //Taking the position of other participants
            l = sc.nextLine();
            //Number of Participants
            int num = Integer.parseInt(l);
            int part[] = new int[num];
            p = 0;
            while (sc.hasNextLine()) {
                l = sc.nextLine();
                part[p] = Integer.parseInt(l);
                p++;
                if (p == num) {
                    break;
                }
            }

            //Transpose graph
            Graph tg = new Graph();
            tg = g1.Transpose();

            //BFS that is only used once
            BFS b = new BFS(tg, lina);
            b.printLowLevel(part);

        } catch (Exception E) {
        }
    }
}
