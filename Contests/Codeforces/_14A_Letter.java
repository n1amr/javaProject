import java.util.Scanner;

public class _14A_Letter {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] a = new char[n][m];
    for (int i = 0; i < n; i++)
      a[i] = in.next().toCharArray();

    int i, j, n1 = -1, n2 = -1, m1 = -1, m2 = -1;
    boolean c;
    for (i = 0; i < n; i++) {
      c = false;
      for (j = 0; j < m; j++)
        if (a[i][j] == '*')
          c = true;
      if (n1 == -1 && c)
        n1 = i;
    }
    for (i = n - 1; i >= 0; i--) {
      c = false;
      for (j = 0; j < m; j++)
        if (a[i][j] == '*')
          c = true;
      if (n2 == -1 && c)
        n2 = i;
    }
    for (j = 0; j < m; j++) {
      c = false;
      for (i = 0; i < n; i++)
        if (a[i][j] == '*')
          c = true;
      if (m1 == -1 && c)
        m1 = j;
    }
    for (j = m - 1; j >= 0; j--) {
      c = false;
      for (i = 0; i < n; i++)
        if (a[i][j] == '*')
          c = true;
      if (m2 == -1 && c)
        m2 = j;
    }
    for (i = n1; i <= n2; i++) {
      for (j = m1; j <= m2; j++)
        System.out.print(a[i][j]);
      System.out.println();
    }
  }
}
