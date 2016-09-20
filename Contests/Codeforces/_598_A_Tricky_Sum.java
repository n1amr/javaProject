import java.io.*;
import java.util.StringTokenizer;

public class _598_A_Tricky_Sum {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(args.length < 1 ? System.in : new FileInputStream(args[0]));
    PrintWriter out = new PrintWriter(args.length < 2 ? System.out : new FileOutputStream(args[1]));
    Solver solver = new Solver();
    int T = in.nextInt();
    for (int t = 0; t < T; t++)
      solver.run(in, out);
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
      long n = in.nextInt();
      long x = n;
      long v = 0;
      while (x != 0) {
        x /= 2;
        v = (v << 1) + 1;
      }
      out.println(n * (n + 1) / 2 - 2 * v);
    }
  }
}
