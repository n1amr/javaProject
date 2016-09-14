import java.util.Scanner;

public class _137B_Permutation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    boolean[] a = new boolean[n];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt() - 1;
      if (x < a.length)
        a[x] = true;
    }
    for (int i = 0; i < a.length; i++)
      if (a[i])
        n--;
    System.out.println(n);
  }
}
