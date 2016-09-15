import java.util.*;

public class _676_A_Nicholas_and_Permutation {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a = -1;
    int b = -1;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      if (x == 1 || x == n)
        if (a == -1) a = i;
        else b = i;
    }
    System.out.println((b - a) + Math.max(a, n - 1 - b));
  }
}
