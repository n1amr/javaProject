public class B {
  public static Scanner in;
  public static PrintWriter out;

  public static void main(String[] args) throws FileNotFoundException {
    in = new Scanner(new BufferedInputStream(new FileInputStream(new File(
        "input.txt"))));
    out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(
        new File("output.txt"))));
    int nCases = in.nextInt();
    in.nextLine();
    for (int CASE = 1; CASE <= nCases; CASE++) {
      out.print("Case #" + CASE + ": ");
      solve();
    }
    out.close();
    System.err.println("Done");
  }

  static int R, C;

  static void solve() {
    R = in.nextInt();
    C = in.nextInt();
    int N = in.nextInt();
    int r = R * (C - 1) + (R - 1) * C;
    int[][] g = new int[R][C];

    for (int i = 0; i < R; i++)
      for (int j = 0; j < C; j++) {
        if (i - 1 >= 0)
          g[i][j]++;
        if (j - 1 >= 0)
          g[i][j]++;
        if (i + 1 < R)
          g[i][j]++;
        if (j + 1 < C)
          g[i][j]++;
      }
    // print(g);
    int max_r = 0, max_c = 0, max_x;
    for (int v = 0; v < R * C - N; v++) {
      max_x = -1;
      LL:
      for (int i = 0; i < R; i++)
        for (int j = 0; j < C; j++) {
          if (g[i][j] <= 0)
            continue;
          if (g[i][j] > max_x) {
            max_x = g[i][j];
            max_r = i;
            max_c = j;
            if (max_x == 4)
              break LL;
          }
        }
      // System.out.println(max_x);
      // System.out.println(max_r);
      // System.out.println(max_c);
      if (max_x > 0) {
        g[max_r][max_c] = 0;
        r -= max_x;

        int i = max_r, j = max_c;
        if (i - 1 >= 0 && g[i - 1][j] != 0)
          g[i - 1][j]--;
        if (j - 1 >= 0 && g[i][j - 1] != 0)
          g[i][j - 1]--;
        if (i + 1 < R && g[i + 1][j] != 0)
          g[i + 1][j]--;
        if (j + 1 < C && g[i][j + 1] != 0)
          g[i][j + 1]--;
      } // print(g);
    }
    out.println(r);
    System.out.println(r);
  }

  private static void print(int[][] g) {
    for (int i = 0; i < R; i++)
      System.out.println(Arrays.toString(g[i]));
  }
}
