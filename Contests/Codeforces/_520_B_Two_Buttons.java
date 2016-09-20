import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _520_B_Two_Buttons {
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
    private static final int MAX = 10001;
    int n;
    int m;


    void run(Scanner in, PrintWriter out) {
      n = in.nextInt();
      m = in.nextInt();

      int c = -1;
      LinkedList<int[]> q = new LinkedList<>();
      boolean[] visited = new boolean[MAX * 2];
      q.addLast(new int[]{n, 0});
      while (q.size() > 0) {
        int[] x = q.removeFirst();
        int u = x[0];
        int c_u = x[1];

        visited[u] = true;
        if (u == m) {
          c = c_u;
          break;
        }

        int v1 = u * 2;
        int v2 = u - 1;
        if (v1 < MAX * 2 && !visited[v1])
          q.addLast(new int[]{v1, c_u + 1});
        if (v2 >= 0 && !visited[v2])
          q.addLast(new int[]{v2, c_u + 1});
      }

      out.println(c);
    }
  }
}
