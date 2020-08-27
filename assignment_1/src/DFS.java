
public class DFS {

    String color[];
    int parent[];
    int time;
    int discovery[];
    int finish[];

    DFS(Graph g) {

        color = new String[g.vertices];
        for (int i = 0; i < color.length; i++) {
            color[i] = "W";
        }
        time = 0;
        parent = new int[g.vertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        discovery = new int[g.vertices];
        for (int i = 0; i < discovery.length; i++) {
            discovery[i] = 0;
        }
        finish = new int[g.vertices];
        for (int i = 0; i < finish.length; i++) {
            finish[i] = 0;
        }
        for (int i = 0; i < g.vertices; i++) {
            if ("W".equals(color[i])) {
                DFS_visit(g, i);
            }
        }
    }

    void DFS_visit(Graph g, int u) {
        time = time + 1;
        discovery[u] = time;
        color[u] = "G";
        for (int i = 0; i < g.adjList.get(u).size(); i++) {
            int v = (Integer) (g.adjList.get(u).get(i));
            if ("W".equals(color[v])) {
                parent[v] = u;
                DFS_visit(g, v);
            }
        }
        color[u] = "B";
        time = time + 1;
        finish[u] = time;
    }

    //Prints the resultt of DFS search, or the last visited node
    void DFS_LastPrint() {
        int p = finish[0];
        int k = 0;
        for (int i = 1; i < finish.length; i++) {
            if (p < finish[i]) {
                p = finish[i];
                k = i;
            }
        }
        System.out.println(k);
    }
}
