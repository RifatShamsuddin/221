import java.awt.*;
import java.io.*;
import java.util.*;

public class Dijkstra {

    //PQ takes the lowest value to the top
    public static PriorityQueue<Node> pq = new PriorityQueue<Node>(new Node());
    public static ArrayList<ArrayList<Node>> arli = new ArrayList<ArrayList<Node>>();

    static int [] d, parent;

    public static void printList(){
        for (int i = 0; i < 5; i++) {
            System.out.print(i+" -->");
            for (int j = 0; j < arli.get(i).size(); j++) {
                System.out.print("["+arli.get(i).get(j).path+", "+arli.get(i).get(j).wt+"]");
            }
            System.out.println();
        }
    }

    public static void sssp(int [][] g, int v, int src){
        d = new int[v];
        parent = new int[v];
        for (int i = 0; i < v; i++) {
            d[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        Set<Integer> set = new HashSet<Integer>(v);
        d[src] = 0;
        set.add(src);
        pq.add(new Node(src, d[src]));
        while (!pq.isEmpty()){
            int u = pq.poll().path;
            set.add(u);
            for (int i = 0; i < v; i++) {
                if(g[u][i] != 0){
                    if(d[i] > d[u] + g[u][i]){
                        d[i] = d[u] + g[u][i];
                        parent[i] = u;
                        pq.add(new Node(i,d[i]));
                    }
                }
            }
//            System.out.println(set);
        }



    }

    public static void printGraph(int [][] g){
        System.out.print("   ");
        for (int i = 0; i < g.length; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < g.length; i++) {
            System.out.print(i+"->");
            for (int j = 0; j < g[0].length; j++) {
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("F:\\Semester 05\\221Lab\\Assignment02\\dijstra.txt"));
        String s;
        s = br.readLine();
        int n = Integer.parseInt(s);
        int [][] graph = new int[n][n];
        while((s = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(s," ");
            int u, v, w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u][v] = w;
        }
        printGraph(graph);
        sssp(graph,n,0);
        for (int i = 0; i < n; i++) {
            System.out.println("distance from "+0+" to "+i+" is "+d[i]);
        }
//        for (int i = 0; i < n; i++) {
//            ArrayList<Node> c = new ArrayList<Node>();
//            arli.add(i, c);
//        }

//        printList();
    }
}

//              0 1 2 3 4
//           0->0 9 6 5 3
//           1->0 0 0 0 0
//           2->0 2 0 4 0
//           3->0 0 0 0 0
//           4->0 0 0 0 0