import java.io.*;
import java.util.StringTokenizer;

public class _706_C_Hard_problem {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(args.length < 1 ? System.in : new FileInputStream(args[0]));
    PrintWriter out = new PrintWriter(args.length < 2 ? System.out : new FileOutputStream(args[1]));
    Solver solver = new Solver();
    if (args.length <= 0) {
      solver.run(in, out);
    } else {
      int T = in.nextInt();
      for (int t = 0; t < T; ) {
        out.printf("Case #%d: ", ++t);
        solver.run(in, out);
      }
    }
    out.close();
  }

  static class Scanner {
    BufferedReader reader;
    StringTokenizer tokenizer = null;

    Scanner(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 1 << 15);
    }

    String nextLine() {
      try {
        return reader.readLine();
      } catch (Exception e) {
        return null;
      }
    }

    String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new StringTokenizer(nextLine());
      return tokenizer.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }

  static class Solver {

    void run(Scanner in, PrintWriter out) {
      int n = in.nextInt();
      long[] c = new long[n + 1];
      String[][] s = new String[n + 1][2];

      c[0] = 0;
      for (int i = 1; i <= n; i++)
        c[i] = in.nextInt();

      StringBuilder sb = new StringBuilder();
      s[0][0] = s[0][1] = "";
      for (int i = 1; i <= n; i++) {
        s[i][0] = in.next();
        sb.setLength(0);
        sb.append(s[i][0]);
        s[i][1] = sb.reverse().toString();
      }

      final long INF = 1L << 60;
      long[][] dp = new long[n + 2][2];
      for (int i = 1; i <= n; i++) {
        for (int j = 0; j < 2; j++) {
          dp[i][j] = Math.min(
              s[i][j].compareTo(s[i - 1][0]) >= 0 ? dp[i - 1][0] + j * c[i] : INF,
              s[i][j].compareTo(s[i - 1][1]) >= 0 ? dp[i - 1][1] + j * c[i] : INF
          );
        }
      }
      Long ans = Math.min(dp[n][0], dp[n][1]);
      out.println(ans == INF ? -1 : ans);
    }
  }
}