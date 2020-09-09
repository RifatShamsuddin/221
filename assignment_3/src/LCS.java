
import java.io.*;
import java.util.*;

public class LCS {

    public int LCS(int[][] g, String arr1[], String arr2[]) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (i == 0 || j == 0) {
                    g[i][j] = 0;
                } else if (arr1[i - 1].equals(arr2[j - 1])) {
                    g[i][j] = g[i - 1][j - 1] + 1;
                } else {
                    g[i][j] = Math.max(g[i - 1][j], g[i][j - 1]);
                }
            }
        }
        return g[arr1.length][arr2.length];
    }

    public String Stringlcs(int[][] g, String[] a, String[] b) {
        int len = LCS(g, a, b);
        String[] c = new String[len + 1];
        for (int i = a.length, j = b.length; i > 0 && j > 0;) {
            if (a[i - 1].equals(b[j - 1])) {
                c[len - 1] = b[j - 1];
                len--;
                i--;
                j--;
            } else if (g[i - 1][j] > g[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        String s = "";
        for (int k = 0; k < c.length - 1; k++) {
            s += c[k];
        }
        return s;
    }
}
