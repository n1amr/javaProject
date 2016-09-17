import java.io.*;
import java.util.StringTokenizer;


public class _546_B_Soldier_and_Badges {
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
      final int MAX = 6666;
      int[] d = new int[MAX];

      int n = in.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        d[a[i]]++;
      }

      int c = 0;
      for (int i = 1; i < MAX; i++) {
        for (int j = i + 1; d[i] > 1 && j < MAX; j++) {
          if (d[j] == 0) {
            d[j]++;
            d[i]--;
            c += j - i;
          }
        }
      }

      out.println(c);
    }
  }
}
