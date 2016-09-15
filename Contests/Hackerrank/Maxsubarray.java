import java.util.Scanner;

public class Maxsubarray {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      int n = in.nextInt();
      int[] a = new int[n];

      boolean containsPos = false;
      for (int i = 0; i < n; i++)
        if ((a[i] = in.nextInt()) > 0)
          containsPos = true;

      int s1 = 0;
      int s2 = 0;

      if (containsPos) {
        int[] dp = new int[n];
        s1 = dp[0] = a[0];
        for (int i = 1; i < n; i++) {
          dp[i] = Math.max(a[i], a[i] + dp[i - 1]);
          s1 = Math.max(s1, dp[i]);
        }

        for (int i = 0; i < n; i++)
          if (a[i] > 0)
            s2 += a[i];

      } else {
        int max = a[0];
        for (int i = 1; i < n; i++)
          max = Math.max(max, a[i]);
        s1 = s2 = max;
      }
      System.out.println(s1 + " " + s2);
    }
  }
}
