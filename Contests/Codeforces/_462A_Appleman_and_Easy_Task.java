import java.util.Scanner;

public class _462A_Appleman_and_Easy_Task {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    char[][] a = new char[n][n];
    for (int i = 0; i < n; i++)
      a[i] = in.next().toCharArray();

    for (int i = 0; i < a.length - 1; i++)
      for (int j = 0; j < a.length; j++) {
        int c = 0;
        if (i > 0 && a[i - 1][j] == 'o')
          c++;
        if (i < a.length - 1 && a[i + 1][j] == 'o')
          c++;
        if (j > 0 && a[i][j - 1] == 'o')
          c++;
        if (j < a.length - 1 && a[i][j + 1] == 'o')
          c++;
        if (c % 2 != 0) {
          System.out.println("NO");
          return;
        }
      }
    System.out.println("YES");
  }
}
