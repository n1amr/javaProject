import java.util.StringTokenizer;

public class CopyOfB {

  public static void main(String[] args) throws IOException {
    CopyOfB main = new CopyOfB();
    main.read();
  }

  /* IO */
  private StringBuilder ans;
  private BufferedReader in;
  private BufferedWriter out;
  private StringTokenizer tok;

  /* fields */
  private int R;
  private int C;
  private int n;
  private boolean[][] g;
  private int dx[] = new int[]{1, -1, 0, 0};
  private int dy[] = new int[]{0, 0, 1, -1};

  private void read() throws IOException {
    // streams
    String inputFileName = "B-small-practice(1).in";
    String outputFileName = "output.txt";
    in = new BufferedReader(new FileReader(inputFileName));
    out = new BufferedWriter(new FileWriter(outputFileName));
    ans = new StringBuilder();

    // read cases
    int nCases = Integer.parseInt(in.readLine());
    for (int cas = 1; cas <= nCases; cas++) {
      System.out.println("case: " + cas);
      tok = new StringTokenizer(in.readLine());
      R = Integer.parseInt(tok.nextToken());
      C = Integer.parseInt(tok.nextToken());
      n = Integer.parseInt(tok.nextToken());

      // solve
      ans.append("Case #" + cas + ": " + solve() + "\n");
    }

    // output
    System.out.print(ans.toString());
    out.write(ans.toString());
    out.flush();
    out.close();

  }

  private int solve() {
    // try all bitmasks
    int min = Integer.MAX_VALUE;
    for (int mask = 0; mask < (1 << (R * C)); mask++) {
      // make bit mask
      g = new boolean[R][C];
      int count = 0;
      for (int i = 0; i < R * C; i++) {
        int r = i / C;
        int c = i % C;
        if (((mask & (1 << i)) == 0))
          g[r][c] = false;
        else {
          g[r][c] = true;
          count++;
        }
      }
      if (count != n)
        continue;

      // count unhappiness
      int unhap = countUnHappiness();
      min = Math.min(min, unhap);
    }

    return min;
  }

  private int countUnHappiness() {
    int count = 0;
    for (int r = 0; r < R; r++)
      for (int c = 0; c < C; c++)
        if (g[r][c])
          for (int i = 0; i < 4; i++) {
            int r2 = r + dx[i];
            int c2 = c + dy[i];
            if (valid(r2, c2))
              if (g[r2][c2])
                count++;

          }
    return count / 2;
  }

  private boolean valid(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }

  private void printG() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++)
        if (g[i][j])
          System.out.print("1 ");
        else
          System.out.print("0 ");
      System.out.println();
    }
    System.out.println();

  }

}
