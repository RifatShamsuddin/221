
import java.io.*;
import java.util.*;

public class problem1 {

    public static void main(String[] args) {
        try {
            String str1, str2;
            File f = new File("N:\\New folder (3)\\221\\assignment_3\\src\\input1.txt");
            Scanner sc = new Scanner(f);
            str1 = sc.nextLine();
            str2 = sc.nextLine();
            String[] x = str1.split(" ");
            String[] y = str2.split(" ");
            int[][] g = new int[x.length + 1][y.length + 1];
            LCS l = new LCS();
            int lengthOfLCS = l.LCS(g, x, y);
            System.out.println(l.Stringlcs(g, x, y));
            double per = (lengthOfLCS * 100.0 / x.length);
            System.out.printf("%.2f%s", per, "% PASSED");
        } catch (Exception e) {
        }
    }
}
