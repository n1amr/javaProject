import java.util.Arrays;
import java.util.Scanner;

public class _234C_Weather {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new FileInputStream(new File("input.txt")));
    int N = in.nextInt();
    int n = N;
    int ans = N;
    int[] b = new int[n];
    int zeros = 0;
    int firstp = b.length;
    int lastn = 0;
    for (int i = 0; i < n; ) {
      int x = in.nextInt();
      if (x == 0) {
        zeros++;
        n--;
      } else {
        b[i] = x;
        if (x > 0) {
          if (firstp == b.length)
            firstp = i;
          i++;
        } else if (x < 0) {
          lastn = i;
          i++;
        }
      }
    }
    if (n > 0) {
      int[] a = new int[n];
      System.arraycopy(b, 0, a, 0, n);
      int np = 0;
      int sp = a[a.length - 1] > 0 ? 1 : 0;
      for (int i = 0; i < lastn; i++) {
        while (a[i] > 0) {
          np++;
          i++;
        }
        if (i > 0 && a[i - 1] > 0)
          sp++;
      }
      int nn = 0;
      int sn = a[0] < 0 ? 1 : 0;
      for (int i = a.length - 1; i >= firstp; i--) {
        while (i >= firstp && a[i] < 0) {
          nn++;
          i--;
        }
        if (i + 1 < a.length && a[i + 1] < 0)
          sn++;
      }
      if (sp > 1 && sn > 1)
        ans = zeros + Math.min(np, nn);
      else if (sp > 1)
        ans = zeros + np;
      else if (sn > 1)
        ans = zeros + nn;
      else
        ans = a[0] < 0 ? 0 : N;
      System.out.println(zeros);
      System.out.println(np);
      System.out.println(nn);
      System.out.println(Arrays.toString(a));
    }
    PrintWriter out = new PrintWriter(new FileOutputStream(new File("output.txt")));
    out.println(ans);
    out.close();
  }
}
