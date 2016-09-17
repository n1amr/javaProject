import java.io.*;
import java.util.StringTokenizer;


public class _716_B_Complete_the_Word {
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
      char[] s = in.next().toCharArray();
      int n = s.length;
      int[] counts = new int[26];

      if (n < 26) {
        out.println(-1);
        return;
      }

      for (int i = 0; i < 26; i++)
        if (s[i] != '?')
          counts[s[i] - 'A']++;

      int index = valid(counts, s);

      if (index >= 0) {
        char[] missing = new char[26];
        int j = 0;
        for (int i = 0; i < 26; i++) {
          if (counts[i] == 0) {
            missing[j++] = (char) (i + 'A');
          }
        }
        j = 0;
        for (int i = index; i < index + 26; i++) {
          if (s[i] == '?') {
            s[i] = missing[j++];
          }
        }
        for (int i = 0; i < n; i++) {
          if (s[i] == '?')
            s[i] = 'X';
        }

        out.println(new String(s));
      } else {
        out.println(-1);
      }
    }

    boolean valid(int[] counts) {
      for (int j = 0; j < 26; j++) {
        if (counts[j] > 1) {
          return false;
        }
      }
      return true;
    }

    int valid(int[] counts, char[] s) {
      int n = s.length;
      if (valid(counts))
        return 0;

      for (int i = 26; i < n; i++) {
        if (s[i] != '?')
          counts[s[i] - 'A']++;
        if (s[i - 26] != '?')
          counts[s[i - 26] - 'A']--;
        if (valid(counts))
          return i + 1 - 26;
      }
      return -1;
    }
  }
}
