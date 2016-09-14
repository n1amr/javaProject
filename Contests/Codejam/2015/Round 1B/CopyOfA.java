public class CopyOfA {
  public static Scanner in;
  public static PrintWriter out;

  public static void main(String[] args) throws FileNotFoundException {
    in = new Scanner(new BufferedInputStream(new FileInputStream(new File(
        "A-small-attempt1.in"))));
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

  static void solve() {
    long N = in.nextLong();
    long r = f(1, 0, N);
    System.out.println(r);
    out.println(r);
  }

  static long f(long c, long r, long N) {
    if (c > N)
      return 1;
    if (c == N)
      return 1;

    long r1 = f(c + 1, r, N);
    if (flip(c) <= c + 1) {
      return 1 + r1;
    }
    long r2 = f(flip(c), r, N);

    return 1 + Math.min(r1, r2);
  }

  static long flip(long n) {
    String s = Long.toString(n);
    String s2 = (new StringBuffer(s)).reverse().toString();
    return Long.valueOf(s2);
  }
}
