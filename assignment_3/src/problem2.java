
import java.io.*;
import java.util.*;

public class problem2 {

    public static void main(String[] args) {
        try {
            String s1, s2;
            File f = new File("N:\\New folder (3)\\221\\assignment_3\\src\\input2.txt");
            Scanner sc = new Scanner(f);
            s1 = sc.nextLine();
            s2 = sc.nextLine();
            String[] x = s1.split(" ");
            String[] y = s2.split(" ");
            int[][] g = new int[x.length + 1][y.length + 1];
            LCS l = new LCS();
            int lengthOfLCS = l.LCS(g, x, y);
            System.out.println(lengthOfLCS);
            String s=l.Stringlcs(g, x, y);
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
