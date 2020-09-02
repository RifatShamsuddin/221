
import java.io.*;
import java.util.*;

public class Demo_2 {

    public static void main(String args[]) {
        try {
            File fl = new File("N:\\New folder (3)\\221\\assignment_2\\src\\input_1.txt");
            Scanner sc = new Scanner(fl);
            String s = sc.nextLine();
            Graph g = new Graph(Integer.parseInt(s));
            s=sc.nextLine();
            g.edges=Integer.parseInt(s);
            for (int i = 0; i < g.edges; i++) {
                s = sc.nextLine();
                String arr[] = new String[3];
                arr = s.split(",");
                g.addEdges(arr[0], arr[1], arr[2]);
            }
            int src=Integer.parseInt(sc.nextLine());
            int dest=Integer.parseInt(sc.nextLine());
            Queue<Integer> avoid = new LinkedList<Integer>();
            s=sc.nextLine();
            String[] arr1=s.split(",");
            for(int i=0;i<arr1.length;i++){
                avoid.add(Integer.parseInt(arr1[i]));
            }
            String location []={"Mouchak","Panthapath","Dhanmondi","Lalmatia","Rampura","Badda","Hatirjheel","Shahabagh","Nilkhet","TSC","Dhaka University","BUET"};
            Dijistra d=new Dijistra(g,src,dest,avoid);
            d.printResultArray(d, src, dest, location);
        } catch (Exception E) {
        }
    }
}

