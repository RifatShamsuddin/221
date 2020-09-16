
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
    
    //Prints the resutlt or the items
    public Stack knapsackPrintLine(int g[][]) {
        Stack q = new Stack();
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

    public void printPlayer(Stack q, String player[]) {
        while (!q.isEmpty()) {
            Object a = q.pop();
            if (q.size() >= 1) {
                System.out.print(player[(Integer) a] + "-->");
            } else {
                System.out.print(player[(Integer) a]);
            }
        }
        System.out.println();
    }

    //For problem 2
    public float getMaxValue(int cap, int num, float g[][]) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (i == 0 || j == 0) {
                    g[i][j] = 0;
                } else if (j < weight[i - 1]) {
                    g[i][j] = g[i - 1][j];
                } else {
                    float p = Math.max(value[i - 1] + g[i - 1][j - weight[i - 1]], g[i - 1][j]);
                    String n = String.format("%.2f", p);
                    g[i][j] = Float.parseFloat(n);
                }
            }
        }
        return g[num][cap];
    }
        public Stack knapsackPrintLine(float g[][]) {
        Stack q = new Stack();
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
