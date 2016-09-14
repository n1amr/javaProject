import java.util.Arrays;
import java.util.Scanner;

public class _489B_BerSU_Ball {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();
    int m = in.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++)
      b[i] = in.nextInt();
    Arrays.sort(a);
    Arrays.sort(b);
    int ans = 0;

    int i = 0, j = 0;

    while (i < n && j < m) {
      while (i < n && j < m && Math.abs(a[i] - b[j]) < 2) {
        ans++;
        i++;
        j++;
      }
      while (i < n && j < m && a[i] - b[j] > 1)
        j++;
      while (i < n && j < m && b[j] - a[i] > 1)
        i++;
    }
    System.out.println(ans);
  }
}
