import java.io.*;
import java.util.*;

public class _326A_Duff_and_Meat {
    public static Scanner in = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            p[i] = in.nextInt();
        }

        int minP = p[0];
        long total = 0;

        for (int i = 0; i < a.length; i++) {
            if (p[i] < minP)
                minP = p[i];
            total += a[i] * minP;
        }

        out.println(total);
        out.close();
    }
}
