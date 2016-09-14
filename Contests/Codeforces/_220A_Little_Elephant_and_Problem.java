import java.util.Arrays;
import java.util.Scanner;

public class _220A_Little_Elephant_and_Problem {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int p = 0;
    String ans = "YES";
    Integer[] a = new Integer[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++)
      b[i] = a[i] = in.nextInt();

    Arrays.sort(a);
    for (int i = 0; i < n; i++)
      if (a[i] != b[i])
        p++;
    if (p > 2)
      ans = "NO";
    System.out.println(ans);
  }
}