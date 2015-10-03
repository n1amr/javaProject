import java.io.*;
import java.util.*;

public class _583A_Asphalting_Roads {
    public static Scanner in = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();

        boolean h[] = new boolean[n];
        boolean v[] = new boolean[n];

        TreeSet<Integer> ans = new TreeSet<Integer>();

        int[] a = new int[n];
        for (int i = 0; i < n * n; i++) {
            int ch = in.nextInt() - 1;
            int cv = in.nextInt() - 1;
            if (!h[ch] && !v[cv]) {
                h[ch] = v[cv] = true;
                ans.add(i + 1);
            }
        }

        for (Integer i : ans) {
            out.print(i + " ");
        }

        out.println();
        out.close();
    }
}
