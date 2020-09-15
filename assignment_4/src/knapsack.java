
import java.io.*;
import java.util.*;

public class knapsack {

    int weight[];
    float value[];
    int cap;

    public knapsack(int cap) {
        this.cap = cap;
        weight = new int[cap];
        value = new float[cap];
    }

    //For problem 1
    public int getMaxValue(int cap, int num, int g[][]) {
        Queue q = new LinkedList();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (i == 0 || j == 0) {
                    g[i][j] = 0;
                } else if (j < weight[i - 1]) {
                    g[i][j] = g[i - 1][j];
                } else {
                    g[i][j] = Math.max((int) value[i - 1] + g[i - 1][j - weight[i - 1]], g[i - 1][j]);
                }
            }
        }
        return g[num][cap];
    }

    public void printArr(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < g[0].length; j++) {
                if (Integer.toString(g[i][j]).length() == 3) {
                    System.out.print(g[i][j] + " ");
                } else if (Integer.toString(g[i][j]).length() == 2) {
                    System.out.print(g[i][j] + "  ");
                } else {
                    System.out.print(g[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public int look(int g[][]) {
        return 0;
    }

    public Queue knapsackPrintLine(int g[][]) {
        Queue q = new LinkedList();
        int i = g.length - 1;
        int j = g[0].length - 1;
        float k = g[i][j];
        for (; i > 0 && k > 0; i--) {
            if (k == g[i - 1][j]) {
                continue;
            } else {
                q.add(i - 1);
                k = k - value[i - 1];
                j = j - weight[i - 1];
            }
        }
        return q;
    }

    public void printPlayer(Queue q, String player[]) {
        while (!q.isEmpty()) {
            Object a = q.poll();
            if (q.size() >= 1) {
                System.out.print(player[(Integer) a] + "-->");
            } else {
                System.out.print(player[(Integer) a]);
            }
        }
    }

    //For problem 2
    public float getMaxValue(int cap, int num, float g[][]) {
        Queue q = new LinkedList();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (i == 0 || j == 0) {
                    g[i][j] = 0;
                } else if (j < weight[i - 1]) {
                    g[i][j] = g[i - 1][j];
                } else {
                    float p = Math.max(value[i - 1] + g[i - 1][j - weight[i - 1]], g[i - 1][j]);
                    String n = String.format("%.1f", p);
                    g[i][j] = Float.parseFloat(n);
                }
            }
        }
        return g[num][cap];
    }

    public void printArr(float[][] g) {
        for (int i = 0; i < g.length; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < g[0].length; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }
    
        public Queue knapsackPrintLine(float g[][]) {
        Queue q = new LinkedList();
        int i = g.length - 1;
        int j = g[0].length - 1;
        float k = g[i][j];
        for (; i > 0 && k > 0&&j>0; i--) {
            if (k == g[i - 1][j]) {
                continue;
            } else {
                q.add(i - 1);
                k -=value[i - 1];
                j -= weight[i - 1];
            }
        }
        return q;
    }
}
