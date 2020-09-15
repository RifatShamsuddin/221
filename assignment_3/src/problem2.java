
import java.io.*;
import java.util.*;

public class problem2 {

    public static void main(String[] args) {
        try {
            String str1, str2;
            File f = new File("N:\\New folder (3)\\221\\assignment_3\\src\\input2.txt");
            Scanner sc = new Scanner(f);
            str1 = sc.nextLine();
            str2 = sc.nextLine();
            String[] x = str1.split(" ");
            String[] y = str2.split(" ");
            int[][] g = new int[x.length + 1][y.length + 1];
            LCS l = new LCS();
            System.out.println(l.LCS(g, x, y));
            String s = l.Stringlcs(g, x, y);
            printLine(s);
        } catch (Exception e) {
        }
    }

    public static void printLine(String s) {
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('M', "monkeys");
        map.put('W', "wearing");
        map.put('C', "coats");
        map.put('A', "are");
        map.put('D', "doctors");
        map.put('B', "because");
        map.put('O', "of");
        map.put('E', "evolution");
        map.put('R', "results");
        map.put('P', "eruption");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(map.get(s.charAt(i)) + " ");
        }
    }
}
