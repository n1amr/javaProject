import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class _651_A_Joysticks {
  public static void main(String[] args) throws Exception {
    String inputFile = (args.length > 0) ? args[0] : null;
    String outputFile = (args.length > 1) ? args[1] : null;

    InputStream inputStream = inputFile != null ?
        new FileInputStream(inputFile) : System.in;
    OutputStream outputStream = outputFile != null ?
        new FileOutputStream(outputFile) : System.out;

    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);

    Solver solver = new Solver();
    if (args.length > 0) {
      int T = in.nextInt();
      for (int t = 1; t <= T; t++) {
        out.printf("Case #%d: ", t);
        solver.solve(in, out, true);
      }
    } else {
      solver.solve(in, out, false);
    }
    out.close();
  }


  static class Solver {
    final int MAX = 150;
    int[][] dp;

    void solve(Scanner in, PrintWriter out, boolean debug) {
      dp = new int[MAX][MAX];
      for (int i = 0; i < MAX; i++)
        Arrays.fill(dp[i], -1);

      out.println(max(in.nextInt(), in.nextInt()));
    }

    int max(int a, int b) {
      if ((a < 2 && b < 2) || (a < 1 || b < 1))
        return 0;

      if (dp[a][b] != -1)
        return dp[a][b];

      return dp[a][b] = 1 + Math.max(max(a - 2, b + 1), max(a + 1, b - 2));
    }
  }
}
