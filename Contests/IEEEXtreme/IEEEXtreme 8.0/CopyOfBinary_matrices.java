import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CopyOfBinary_matrices {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    boolean[][] a = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt() == 1;
      }
    }
    ArrayList<String> errors1 = new ArrayList<String>();
    ArrayList<String> errors2 = new ArrayList<String>();

    for (int i = 0; i < n - 1; i++) {
      boolean c = false;
      for (int j = 0; j < m; j++) {
        if (a[i][j] != a[i + 1][j] && a[n - 1][j] == a[i + 1][j]) {
          c = true;
          break;
        }
      }
      if (!c)
        errors1.add("i1=" + (i + 1));
    }
    for (int i1 = 0; i1 < n - 1; i1++) {
      for (int i2 = i1 + 1; i2 < n - 1; i2++) {
        boolean c = false;
        for (int j = 0; j < m; j++) {
          if (a[i1][j] != a[i1 + 1][j]
              && a[i1 + 1][j] == a[i2 + 1][j]
              && a[i2][j] == a[i2 + 1][j]) {
            c = true;
            break;
          }
        }
        if (!c)
          errors2.add("i1=" + (i1 + 1) + " i2=" + (i2 + 1));
      }
    }

    System.out.println(errors1.size() + errors2.size());
    Collections.sort(errors2);
    for (String err : errors1)
      System.out.println(err);
    for (String err : errors2)
      System.out.println(err);
  }
}
