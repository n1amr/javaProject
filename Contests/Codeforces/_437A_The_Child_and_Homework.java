import java.util.Scanner;

public class _437A_The_Child_and_Homework {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] a = new int[4];
    boolean[] b = new boolean[4];
    for (int i = 0; i < 4; i++)
      a[i] = in.next().length() - 2;
    int s = 2;
    b = greatChoices(a);
    int n = 0;
    for (int i = 0; i < 4; i++)
      if (b[i]) {
        n++;
        s = i;
      }
    if (n != 1)
      s = 2;
    System.out.println((char) ('A' + s));
  }

  private static boolean isSmaller(int[] a, int n) {
    boolean r = true;
    for (int i = 0; i < 4; i++)
      if (i != n)
        r = r && a[n] * 2 <= a[i];
    return r;
  }

  private static boolean[] greatChoices(int[] a) {
    boolean[] r = new boolean[4];
    for (int i = 0; i < 4; i++)
      r[i] = isLarger(a, i) || isSmaller(a, i);
    return r;
  }

  private static boolean isLarger(int[] a, int n) {
    boolean r = true;
    for (int i = 0; i < 4; i++)
      if (i != n)
        r = r && a[n] >= a[i] * 2;
    return r;
  }
}