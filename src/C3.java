import java.io.*;
import java.util.*;

public class C3 {
    public static Scanner in = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = 1;
        int g[][] = new int[n][n];
        int pg = 0;

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < n * n; i++) {
            int a = (i < n * n / 2) ? 1 : (i < 3 * n * n / 4 ? 3 : 4);

            if (!mp.containsKey(a))
                mp.put(a, 0);

            mp.put(a, mp.get(a) + 1);
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> allnumbers = new ArrayList<Integer>();
        for (Integer i : mp.keySet()) {
            allnumbers.add(i);
            if (mp.get(i) % 2 != 0) {
                arr.add(i);
                g[pg][pg] = i;
                pg++;
                mp.put(i, mp.get(i) - 1);
            }
        }

        Collections.sort(allnumbers);
        Collections.reverse(allnumbers);

        while (arr.size() < n) {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.size(); j++) {
                    if (g[i][j] != 0 || g[i][i] == 0 || g[j][j] == 0)
                        continue;
                    int gc = gcd(arr.get(i), arr.get(j));
                    g[i][j] = gc;
                    mp.put(gc, mp.get(gc) - 1);
                }
            }

            for (Integer i : allnumbers) {
                int c = mp.get(i);
                if (c == 0)
                    continue;

                arr.add(i);
                g[pg][pg] = i;
                pg++;
                mp.put(i, mp.get(i) - 1);
                break;
            }

        }

        for (Integer i : arr)
            out.print(i + " ");
        out.println();
        out.close();

    }

    private static void printG(int g[][]) {
        for (int ii = 0; ii < g.length; ii++) {
            for (int jj = 0; jj < g[0].length; jj++) {
                System.out.print(g[ii][jj] + " ");
            }
            System.out.println();
        }
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
