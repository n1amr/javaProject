import java.util.Scanner;

public class _474_D_Flowers {
  static final int MAX = 100005;
  static final int MOD = 1000000007;

  static int add(int a, int b) {
    return (int) (((long) a + b) % MOD);
  }

  static int sub(int a, int b) {
    return (int) (((long) (a - b) % MOD + MOD) % MOD);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int k = in.nextInt();

    int[] ways = new int[MAX];
    for (int i = 0; i < k; i++)
      ways[i] = 1;
    for (int i = k; i < MAX; i++)
      ways[i] = add(ways[i - 1], ways[i - k]);
    for (int i = 1; i < MAX; i++)
      ways[i] = add(ways[i - 1], ways[i]);

    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      System.out.println(sub(ways[b], ways[a - 1]));
    }
  }
}
