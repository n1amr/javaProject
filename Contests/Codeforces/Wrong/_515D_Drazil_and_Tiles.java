import java.util.Arrays;
import java.util.Scanner;

public class _515D_Drazil_and_Tiles {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();
    out.println(Arrays.toString(a));
    out.close();
  }
}
