import java.util.Comparator;

public class Node implements Comparator<Node> {
    public int dst,src , wt;
    public Node(){

    }
    public Node(int s,int d, int w){
        dst=d;
        src=s;
        wt=w;
    }

    public int compare(Node n1, Node n2){
        if(n1.wt > n2.wt){
            return 1;
        }
        else if(n1.wt < n2.wt){
            return -1;
        }
        else
            return 0;
    }
}
