import java.util.*;

public class _680_A_Bear_and_Five_Cards {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] a = new int[5];
    for (int i = 0; i < 5; i++)
      a[i] = in.nextInt();
    Arrays.sort(a);
    int SUM = Arrays.stream(a).sum();
    int min = SUM;
    for (int k = 2; k <= 3; k++)
      for (int i = 0; i + k <= 5; i++) {
        int s = a[i];
        for (int j = i + 1; j < i + k; j++) {
          s += a[i];
          if (a[j] != a[j - 1])
            s = -Integer.MAX_VALUE / 2;
        }
        min = Math.min(min, SUM - s);
      }
    System.out.println(min);
  }
}
