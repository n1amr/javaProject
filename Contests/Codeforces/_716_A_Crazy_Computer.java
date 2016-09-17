import java.io.*;
import java.util.StringTokenizer;


public class _716_A_Crazy_Computer {
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

  static class Scanner {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public Scanner(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new StringTokenizer(nextLine());
      return tokenizer.nextToken();
    }

    public String nextLine() {
      try {
        return reader.readLine();
      } catch (IOException e) {
        return null;
      }
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }

  static class Solver {
    void solve(Scanner in, PrintWriter out, boolean debug) {
      int n = in.nextInt();
      int c = in.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++)
        a[i] = in.nextInt();

      int count = 1;
      for (int i = 1; i < n; i++) {
        if (a[i] - a[i - 1] > c)
          count = 0;
        count++;
      }

      out.println(count);
    }
  }
}
