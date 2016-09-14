import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class _369B_Valera_and_Contest {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new FileInputStream(new File("input.txt")));
    // Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int l = in.nextInt();
    int r = in.nextInt();
    int Sall = in.nextInt();
    int Sk = in.nextInt();
    int sall = Sall;
    int[] a = new int[n];
    Arrays.fill(a, (sall + n - 1) / n);
    // sk -= a[0] * k;
    // sall -= a[0] * n;
    // System.out.println(sall);
    // System.out.println(sk);
    // int last = 0;
    // for (int i = 0; i < k; i++)
    // if (sk > 0) {
    // sk += a[i];
    // sall += a[i];
    // a[i] = 0;
    // if (sk >= r) {
    // a[i] = r;
    // } else {
    // last = i;
    // a[i] = sk;
    // }
    // sk -= a[i];
    // sall -= a[i];
    // }
    // System.out.println(last);
    // int q = sall / (n - last - 1);
    // for (int i = last; i < a.length; i++) {
    // a[i] += q;
    // }

    PrintWriter out = new PrintWriter(new File("output.txt"));
    for (int i = 0; i < n; i++) {
      out.print(a[i] + " ");
      if (i == k - 1)
        out.println("\n-------------------------------------");
      if (i % 10 == 0)
        out.println();
    }
    out.close();

    System.out.println(isCorrect(a, n, k, l, r, Sk, Sall));
  }

  private static boolean isCorrect(int[] a, int n, int k, int l, int r, int sk, int sall) {
    Arrays.sort(a);
    for (int i = 0; i < a.length / 2; i++) {
      int swap_temp = a[i];
      a[i] = a[a.length - 1 - i];
      a[a.length - 1 - i] = swap_temp;
    }

    for (int i = 0; i < a.length; i++) {
      if (a[i] > r || a[i] < l)
        return false;
      sall -= a[i];
      if (i < k)
        sk -= a[i];
    }
    System.out.println("sk: " + sk);
    System.out.println("sall: " + sall);
    return sk == 0 && sall == 0;
  }
}
