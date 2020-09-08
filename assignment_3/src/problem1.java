import java.io.*;
import java.util.*;
public class problem1 {

    public static void main(String[] args) {
        try {
            String s1, s2;
            File f = new File("N:\\New folder (3)\\221\\assignment_3\\src\\input1.txt");
            Scanner sc = new Scanner(f);
            s1 = sc.nextLine();
            s2 = sc.nextLine();
            String[] x = s1.split(" ");
            String[] y = s2.split(" ");
            int[][] g = new int[x.length + 1][y.length + 1];
            LCS l=new LCS();
            int lengthOfLCS = l.LCS(g, x, y);
            System.out.println(l.Stringlcs(g, x, y));
            double result = (lengthOfLCS * 100.0 /x.length);
            System.out.printf("%.2f%s", result, "% PASSED");
        } catch (Exception e) {
        }
    }
}
