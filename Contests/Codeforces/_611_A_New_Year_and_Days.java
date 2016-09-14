public class _611_A_New_Year_and_Days {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int n = in.nextInt();
    in.next();
    String s = in.next();

    int c = 0;
    if (s.equals("week"))
      c = 52 + (n == 5 || n == 6 ? 1 : 0);
    else
      c = 12 - (n > 29 ? 1 : 0) - (n > 30 ? 1 : 0) * 4;
    out.println(c);
    out.close();
  }
}
