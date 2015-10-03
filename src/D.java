import java.io.*;
import java.util.*;

public class D {
    public static Scanner in = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int T = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int b[] = new int[n * T];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < n; j++) {
                b[i * n + j] = a[j];
            }
        }
        System.out.println(maxLength(a, 0, a[0]));

        int maxElement = 0;
        int maxElementCount = 0;
        for (int i = 0; i < n; i++) {
            if (maxElement < a[i]) {
                maxElement = a[i];
                maxElementCount = 1;
            } else if (maxElement == a[i])
                maxElementCount++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int last = a[i];
            int c = 1;
            for (int s = 0; s < T; s++) {
                for (int j = i; j < n; j++) {
                    if (last <= a[j % n]) {
                        c++;
                        last = a[j % n];
                    }
                }
                if (last == maxElement) {
                    c = c - 1 + (T - s) * maxElementCount;
                    break;
                }
            }
            max = Math.max(max, c);
        }
        out.println(max);
        out.close();
    }

    static int maxLength(int a[], int i, int last) {
        if (i >= a.length - 1)
            return 0;
        int c1 = 0;
        int c2 = 0;
        for (int j = i; j < a.length; j++) {
            if (a[j] <= last) {
                c1 = Math.max(c, 1 + maxLength(a, j, a[j]));
            }
        }
        c2 = maxLength(a, i + 1, last);
        return Math.max(c1, c2);
    }
}
