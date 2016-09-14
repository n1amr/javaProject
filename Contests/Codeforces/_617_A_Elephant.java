public class _617_A_Elephant {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int x = in.nextInt();
    out.println((x - 1) / 5 + 1);
    out.close();
  }
}
