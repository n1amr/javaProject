import java.io.*;
import java.util.Scanner;

public class _550_A_Two_Substrings {
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
    if (args.length == 0)
      solver.solve(1, in, out);
    else {
      int T = in.nextInt();
      for (int t = 1; t <= T; t++) {
        out.println("Case " + t + ":");
        solver.solve(t, in, out);
      }
    }

    out.close();
  }

  static class Solver {
    void solve(int testNumber, Scanner in, PrintWriter out) {
      String s = in.next();
      int i1 = s.indexOf("AB");
      int i2 = s.lastIndexOf("BA");
      int i3 = s.indexOf("BA");
      int i4 = s.lastIndexOf("AB");

      out.println(
          (s.length() > 3 &&
              (i1 >= 0 && i2 >= 0 && i1 + 1 < i2) ||
              (i4 >= 0 && i3 >= 0 && i3 + 1 < i4)) ?
              "YES" : "NO");
    }

  }
}
