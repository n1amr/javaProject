import java.io.*;
import java.util.StringTokenizer;

public class _545_A_Toy_Cars {
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
      int[][] a = new int[n][n];
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          a[i][j] = in.nextInt();

      int c = 0;
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
          if (i == j)
            continue;
          int x = a[i][j];
          if (x == 3 || x == 1)
            a[i][i] = 0;
          if (x == 3 || x == 2)
            a[j][j] = 0;
        }

      for (int i = 0; i < n; i++)
        if (a[i][i] < 0) c++;
      out.println(c);
      for (int i = 0; i < n; i++)
        if (a[i][i] < 0) out.print((i + 1) + " ");
      out.println();
    }
  }
}
