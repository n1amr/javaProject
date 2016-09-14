import java.util.Scanner;

public class _282B_Painting_Eggs {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    int[] g = new int[n];
    int A = 0, G = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      g[i] = in.nextInt();
    }
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < n; i++)
      if (A + a[i] - G <= 500) {
        A += a[i];
        s.append('A');
      } else {
        G += g[i];
        s.append('G');
      }
    if (Math.abs(A - G) <= 500)
      System.out.println(s);
    else
      System.out.println(-1);
  }
}
