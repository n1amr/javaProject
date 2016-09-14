import java.util.Arrays;
import java.util.Scanner;

public class _701_A_Cards {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] a = new int[n][2];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = i + 1;
    }
    Arrays.sort(a, (o1, o2) -> (o1[0] - o2[0]));
    for (int i = 0; 2 * i < n; i++)
      System.out.println(a[i][1] + " " + a[n - 1 - i][1]);
  }
}
