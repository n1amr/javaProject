import java.io.*;
import java.util.*;

public class _583B_Robot_s_Task {
    public static Scanner in = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] a = new int[n];
        boolean[] checked = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int changes = 0;
        int info = 0;

        int i = 0;
        int direction = 1;
        while (true) {
            if (!checked[i] && a[i] <= info) {
                info++;
                checked[i] = true;
            }

            if (info == n)
                break;

            if ((direction == 1 && i == n - 1) || (direction == -1 && i == 0)) {
                direction *= -1;
                changes++;
            }

            i += direction;
        }

        out.println(changes);
        out.close();
    }
}
