import java.util.Scanner;

public class B {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static boolean valid(int r, int c) {
    return (r >= 0) && (r < 8) && (c >= 0) && (c < 8);
  }

  public static int[][] places(int r, int c) {
    int[][] ans = new int[8][2];
    ans[0][0] = r - 2;
    ans[0][1] = c - 1;
    ans[1][0] = r - 2;
    ans[1][1] = c + 1;
    ans[2][0] = r - 1;
    ans[2][1] = c - 2;
    ans[3][0] = r - 1;
    ans[3][1] = c + 2;
    ans[4][0] = r + 1;
    ans[4][1] = c - 2;
    ans[5][0] = r + 1;
    ans[5][1] = c + 2;
    ans[6][0] = r + 2;
    ans[6][1] = c - 1;
    ans[7][0] = r + 2;
    ans[7][1] = c + 1;
    return ans;
  }

  public static boolean threatens(int r, int c, int or, int oc) {
    int[][] p = places(r, c);

    for (int i = 0; i < 8; i++)
      if (valid(p[i][0], p[i][1]) && p[i][0] == or && p[i][1] == oc)
        return true;

    return false;
  }

  public static void main(String[] args) {
    String[] a = new String[8];
    int kr, kc, qr, qc, nr, nc;
    kr = kc = qr = qc = nr = nc = -1;
    for (int i = 0; i < 8; i++) {
      a[i] = in.next();
      if (a[i].indexOf('K') >= 0) {
        kr = i;
        kc = a[i].indexOf('K');
      }
      if (a[i].indexOf('Q') >= 0) {
        qr = i;
        qc = a[i].indexOf('Q');
      }
      if (a[i].indexOf('N') >= 0) {
        nr = i;
        nc = a[i].indexOf('N');
      }
    }

    String ans = null;

    int[][] p = places(nr, nc);
    for (int i = 0; i < 8; i++) {
      int r = p[i][0];
      int c = p[i][1];

      if (valid(r, c) && threatens(r, c, kr, kc) && threatens(r, c, qr, qc)) {
        ans = ("YES " + (char) ('8' - r) + (char) ('A' + c));
      }
    }

    if (ans == null)
      out.println("NO");
    else
      out.println(ans);
    out.close();
  }
}
