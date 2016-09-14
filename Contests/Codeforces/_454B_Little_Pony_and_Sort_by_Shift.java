import java.util.Scanner;

public class _454B_Little_Pony_and_Sort_by_Shift {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    int[] c = new int[n];
    int start = 0;

    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();

    for (int i = 1; i < n; i++)
      if (a[i] < a[i - 1]) {
        start = i;
        break;
      }

    for (int i = 0; i < c.length; i++)
      c[i] = a[(i + start) % n];

    if (isSorted(c))
      System.out.println((n - start) % n);
    else
      System.out.println(-1);
  }

  private static boolean isSorted(int[] a) {
    for (int i = 1; i < a.length; i++)
      if (a[i - 1] > a[i])
        return false;
    return true;
  }
}
