public class _527_A_Playing_with_Paper {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static long f(long a, long b) {
    if (a < b)
      return f(b, a);
    else if (a == 0 || b == 0)
      return 0;
    else
      return a / b + f(b, a % b);
  }

  public static void main(String[] args) {
    long a = in.nextLong();
    long b = in.nextLong();
    out.println(f(a, b));
    out.close();
  }
}
