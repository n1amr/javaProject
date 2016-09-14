public class _560_A_Currency_System_in_Geraldion {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int n = in.nextInt();
    boolean found = false;
    for (int i = 0; i < n; i++)
      found |= in.nextInt() == 1;
    out.println(found ? "-1" : "1");
    out.close();
  }
}
