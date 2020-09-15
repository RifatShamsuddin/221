
import java.io.*;
import java.util.*;

public class problem1 {

    public static void main(String args[]) {
        try {
            File f = new File("N:\\New folder (3)\\221\\assignment_4\\src\\input_1.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            int budget = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());
            int g[][] = new int[num + 1][budget + 1];
            br.readLine();
            String st;
            String player[] = new String[num];
            int i = 0;
            knapsack k = new knapsack(num);
            while ((st = br.readLine()) != null) {
                StringTokenizer tkn = new StringTokenizer(st, ",");
                player[i] = tkn.nextToken();
                k.weight[i] = Integer.parseInt(tkn.nextToken());
                k.value[i] = Integer.parseInt(tkn.nextToken());
                i++;
            }
            System.out.println(k.getMaxValue(budget, num, g));
            k.printPlayer(k.knapsackPrintLine(g), player);
        } catch (Exception e) {
        }
    }

}
