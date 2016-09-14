import java.util.Scanner;

public class _450A_Jzzhu_and_Children {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();
    int max = 0;
    int index = 0;
    int c;
    for (int i = 0; i < n; i++) {
      c = 0;
      while (a[i] > 0) {
        a[i] -= m;
        c++;
      }
      if (c >= max) {
        max = c;
        index = i;
      }
    }
    System.out.println(index + 1);
  }
}
