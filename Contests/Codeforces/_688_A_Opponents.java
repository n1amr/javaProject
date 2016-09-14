import java.util.Scanner;

public class _688_A_Opponents {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    in.nextInt();
    int d = in.nextInt();
    boolean[] a = new boolean[d];
    for (int i = 0; i < d; i++)
      for (char value : in.next().toCharArray())
        if (value == '0')
          a[i] = true;

    int c = 0;
    int max = 0;
    for (boolean x : a)
      max = Math.max(max, c = x ? c + 1 : 0);

    System.out.println(max);
  }
}
