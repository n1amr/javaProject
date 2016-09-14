import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class _459B_Pashmak_and_Flowers {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long max = 0;
    BigInteger ways;
    int n = in.nextInt();
    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextLong();
    Arrays.sort(a);
    max = a[a.length - 1] - a[0];
    long c1 = 1, c2 = 1;
    if (max != 0) {
      for (int i = 1; i < a.length && a[i] == a[i - 1]; i++)
        c1++;
      for (int i = a.length - 2; i >= 0 && a[i] == a[i + 1]; i--)
        c2++;
      ways = new BigInteger(Long.toString(c1)).multiply(new BigInteger(Long.toString(c2)));
    } else {
      BigInteger nn = new BigInteger(Integer.toString(n));
      ways = nn.multiply(nn.subtract(BigInteger.ONE)).divide(new BigInteger("2"));
    }
    System.out.println(max + " " + ways.toString());
  }

  static long factorial(long n) {
    long ans = 1;
    for (long i = 1; i <= n; i++)
      ans *= i;
    return ans;
  }
}
