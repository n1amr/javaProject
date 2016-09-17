import java.util.Scanner;

public class _716_C_Plus_and_Square_Root {
  public static void main(String[] args) throws Exception {
    int n = new Scanner(System.in).nextInt();
    long currentLcm = 2;
    long nextLcm;
    for (int level = 1; level <= n; level++) {
      nextLcm = lcm(level, level + 1);
      long k = nextLcm / level * nextLcm - currentLcm / level;
      System.out.println(k);
      currentLcm = nextLcm;
    }
  }

  static long gcd(long a, long b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  static long lcm(long a, long b) {
    return a * b / gcd(a, b);
  }
}

