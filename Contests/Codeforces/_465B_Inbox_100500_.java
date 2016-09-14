import java.util.Scanner;

public class _465B_Inbox__100500_ {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; i++)
      a[i] = in.nextInt();
    if (n == 1)
      System.out.println(a[0]);
    else {
      int[] DP = new int[n];
      DP[0] = a[0];
      DP[1] = a[1] + DP[0];
      for (int i = 2; i < DP.length; i++)
        DP[i] = a[i] + DP[i - 1] + (DP[i - 1] != 0 && a[i - 1] == 0 && a[i] == 1 ? 1 : 0);
      System.out.println(DP[n - 1]);
    }
  }
}
