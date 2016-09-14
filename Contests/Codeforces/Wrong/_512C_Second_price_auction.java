import java.util.Scanner;

public class _512C_Second_price_auction {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] L = new int[5];
    int[] R = new int[5];
    int c = 1;
    for (int i = 0; i < n; i++) {
      L[i] = in.nextInt();
      R[i] = in.nextInt();
      c = c * (R[i] - L[i] + 1);
    }
    double sum = 0;
    for (int i = L[0]; i <= R[0]; i++) {
      if (L[1] < i)
        sum += sum(L[1], i - 1);
      if (R[1] - i + 1 > 0)
        sum += i * (R[1] - i + 1);
    }
    System.out.println(sum * 1.0 / c);
  }

  private static double sum(int i, int j) {
    return (j - 1 + 1) * (i + j) / 2.0;
  }
}
