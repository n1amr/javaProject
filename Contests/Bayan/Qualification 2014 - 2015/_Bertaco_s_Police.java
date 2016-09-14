import java.util.Scanner;

public class _Bertaco_s_Police {
  static Scanner in;
  static PrintWriter out;

  public static void main(String[] args) throws FileNotFoundException {
    in = new Scanner(new BufferedInputStream(new FileInputStream(new File("input.txt"))));
    out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))));
    int nCases = in.nextInt();
    in.nextLine();
    for (int CASE = 1; CASE <= nCases; CASE++)
      solve();
    out.close();
  }

  static void solve() {
    String n = in.next();
    out.println(new StringBuilder(n).reverse());
  }
}
