
import java.io.*;
import java.util.*;

public class problem2 {

    public static void main(String args[]) {
        try {
            File f = new File("N:\\New folder (3)\\221\\assignment_4\\src\\input_2.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            int cap = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());
            float g[][] = new float[num + 1][cap + 1];
            String trophy[] = new String[num];
            String clubs[] = new String[num];
            br.readLine();
            String st;
            int i = 0;
            knapsack k = new knapsack(num);
            while ((st = br.readLine()) != null) {
                StringTokenizer tkn = new StringTokenizer(st, ",");
                clubs[i] = tkn.nextToken();
                k.weight[i] = Integer.parseInt(tkn.nextToken());
                k.value[i] = Float.parseFloat(tkn.nextToken());
                trophy[i] = tkn.nextToken();
                i++;
            }
            System.out.println("Name of clubs whose trophies were sold:");
            float l=k.getMaxValue(cap, num, g);
            k.printPlayer(k.knapsackPrintLine(g), clubs);
            System.out.println("Maximum money he earned: "+l);
            
        } catch (Exception A) {
        }
    }

}
