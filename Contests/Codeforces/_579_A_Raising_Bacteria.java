public class _579_A_Raising_Bacteria {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int n = in.nextInt();
    int c = 0;
    while (n > 0) {
      c += n % 2;
      n >>= 1;
    }
    out.println(c);
    out.close();
  }
}
