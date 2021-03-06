import java.io.*;
import java.util.StringTokenizer;

public class _706_B_Interesting_drink {
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
      final int MAX = 100_001;
      int n = in.nextInt();
      int[] c = new int[MAX];
      for (int i = 0; i < n; i++)
        c[in.nextInt()]++;
      for (int i = 1; i < MAX; i++)
        c[i] += c[i - 1];

      int q = in.nextInt();
      for (int i = 0; i < q; i++) {
        int x = in.nextInt();
        out.println(x < MAX ? c[x] : n);
      }
    }
  }
}
