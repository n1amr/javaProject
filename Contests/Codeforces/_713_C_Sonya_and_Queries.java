import java.util.StringTokenizer;
import java.util.TreeMap;

public class _714_C_Sonya_and_Queries {
  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        (args.length <= 0) ?
            System.in : new FileInputStream(args[0]);
    OutputStream outputStream =
        (args.length <= 1) ?
            System.out : new FileOutputStream(args[1]);
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Solver solver = new Solver();
    solver.solve(1, in, out);
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
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }
  }

  static class Solver {
    void solve(int testNumber, Scanner in, PrintWriter out) {
      int n = in.nextInt();
      TreeMap<String, Integer> d = new TreeMap<>();

      for (int i = 0; i < n; i++) {
        String op = in.next();
        String x = in.next();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 19 - x.length(); j++)
          sb.append('0');
        for (int j = 0; j < x.length(); j++)
          sb.append(x.charAt(j) % 2 == 0 ? '0' : '1');

        String p = sb.toString();
        int old = 0;
        if (d.containsKey(p))
          old = d.get(p);

        if (op.equals("?"))
          out.println(old);
        else
          d.put(p, old + (op.equals("+") ? 1 : -1));
      }
    }
  }
}