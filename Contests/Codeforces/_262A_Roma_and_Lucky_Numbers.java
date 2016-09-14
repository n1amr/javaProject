import java.util.Scanner;

public class _262A_Roma_and_Lucky_Numbers {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int r = 0;
    for (int i = 0; i < n; i++)
      if (isTrue(in.nextInt(), k))
        r++;
    System.out.println(r);
  }

  private static boolean isTrue(int nextInt, int k) {
    return count(nextInt) <= k;
  }

  private static int count(int nextInt) {
    String s = Integer.toString(nextInt);
    int r = 0;
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) == '4' || s.charAt(i) == '7')
        r++;

    return r;
  }
}
