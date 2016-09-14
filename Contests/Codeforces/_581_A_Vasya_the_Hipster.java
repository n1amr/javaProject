public class _581_A_Vasya_the_Hipster {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int a = in.nextInt();
    int b = in.nextInt();
    int x = a < b ? a : b;
    int y = (a + b - 2 * x) / 2;
    out.println(x + " " + y);
    out.close();
  }
}
