import java.io.*;
import java.util.*;

public class CodeJam2016C {
  public static Scanner in;
  public static PrintWriter out;

  public static void main(String[] args) throws FileNotFoundException {
    initialize();
    System.out.println("Start execution?");
    (new Scanner(System.in)).nextLine();

    in = new Scanner(new BufferedInputStream(new FileInputStream(new File("C-small-attempt0.in"))));
    out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))));

    int nCases = in.nextInt();
    in.nextLine();
    for (int CASE = 1; CASE <= nCases; CASE++) {
      out.println("Case #" + CASE + ": ");
      solve();
    }
    out.close();
    System.out.println("Done");
  }

  static int bound = 200000000;
  static int[] divisor;

  static void initialize() {
    divisor = new int[bound];
    for (int i = 1; i < bound; i++)
      divisor[i] = -1;

    for (int i = 2; i < bound; i++)
      if (divisor[i] == -1)
        for (int j = i * 2; j < bound; j += i)
          divisor[j] = i;
  }

  static void solve() {
    int N = in.nextInt();
    int J = in.nextInt();
    for (int n = (1 << (N - 1)) + 1; J > 0 && n < (1 << N); n += 2) {
      int[] bases = basenumbers(n);
      boolean j = true;
      for (int i = 0; j && i < bases.length; i++)
        j = divisor[bases[i]] != -1;

      if (j) {
        out.print(decimal_to_binary(n));
        for (int i = 0; i < bases.length; i++)
          out.print(" " + divisor[bases[i]]);
        out.println();
        J--;
      }
    }
  }

  static long decimal_to_binary(long x) {
    long n = 0;
    while (x != 0) {
      n *= 10;
      n += x % 2;
      x >>= 1;
    }
    return n;
  }

  static int[] basenumbers(int n) {// n is decimal of string_to_binary
    int[] r = new int[9];
    int[] d = new int[9];
    for (int i = 0; i < d.length; i++) {
      r[i] = 0;
      d[i] = 1;
    }
    while (n != 0) {
      int digit = n % 2;
      for (int i = 0; i < d.length; i++) {
        r[i] += digit * d[i];
        d[i] *= i + 2;
      }
      n /= 2;
    }
    return r;
  }
}
