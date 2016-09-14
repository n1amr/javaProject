import java.util.Arrays;
import java.util.Scanner;

public class _471B_MUH_and_Important_Things {
  static class Pair implements Comparable<Pair> {
    int v, i;

    public Pair(int nextInt, int i2) {
      v = nextInt;
      i = i2 + 1;
    }

    public int compareTo(Pair o) {
      return v - o.v;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Pair[] a = new Pair[n];
    for (int i = 0; i < n; i++)
      a[i] = new Pair(in.nextInt(), i);
    Arrays.sort(a);
    int[] p = new int[2];
    int pos = 0;
    for (int i = 1; i < a.length; i++)
      if (a[i].v == a[i - 1].v) {
        p[pos++] = i;
        if (pos == 2)
          break;
      }

    if (pos == 2) {
      System.out.println("YES");
      print(a);
      Pair swap_temp = a[p[0]];
      a[p[0]] = a[p[0] - 1];
      a[p[0] - 1] = swap_temp;
      print(a);
      swap_temp = a[p[1]];
      a[p[1]] = a[p[1] - 1];
      a[p[1] - 1] = swap_temp;
      print(a);
    } else
      System.out.println("NO");
  }

  private static void print(Pair[] a) {
    for (int i = 0; i < a.length; i++)
      System.out.print(a[i].i + " ");
    System.out.println();
  }
}
