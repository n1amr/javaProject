import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Magic_Square {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        a[i][j] = in.nextInt();
    ArrayList<Integer> v = new ArrayList<Integer>();
    long s = 0;
    for (int i = 0; i < n; i++)
      s += a[i][i];

    for (int i = 0; i < n; i++) {
      long c = 0;
      for (int j = 0; j < n; j++)
        c += a[i][j];
      if (c != s)
        v.add(i + 1);
    }
    for (int j = n - 1; j >= 0; j--) {
      long c = 0;
      for (int i = 0; i < n; i++)
        c += a[i][j];
      if (c != s)
        v.add(-j - 1);
    }
    long c = 0;
    for (int i = 0; i < n; i++)
      c += a[i][n - 1 - i];
    if (c != s)
      v.add(0);
    System.out.println(v.size());
    Collections.sort(v);
    for (Integer i : v)
      System.out.println(i);
  }
}
