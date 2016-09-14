import java.util.Scanner;

public class _352A_Jeff_and_Digits {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int n0 = 0, n5 = 0;
    for (int i = 0; i < n; i++)
      if (in.nextInt() == 0)
        n0++;
      else
        n5++;
    if (n0 == 0)
      System.out.println(-1);
    else {
      int d = n5 / 9 * 9;
      for (int i = 0; i < d; i++)
        System.out.print(5);
      if (d == 0)
        n0 = 1;
      for (int i = 0; i < n0; i++)
        System.out.print(0);
      System.out.println();

    }
  }
}
