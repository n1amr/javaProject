public class _621_A_Wet_Shark_and_Odd_and_Even {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int n = in.nextInt();
    long sum = 0;
    int odds = 0;
    long min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      sum += x;
      if (x % 2 == 1) {
        odds++;
        min = Math.min(min, x);
      }
    }
    sum -= (odds % 2) * min;
    out.println(sum);
    out.close();
  }
}
