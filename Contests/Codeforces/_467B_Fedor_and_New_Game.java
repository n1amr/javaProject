import java.util.Scanner;

public class _467B_Fedor_and_New_Game {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    String[] a = new String[m + 1];
    int c = 0;
    for (int i = 0; i < m + 1; i++) {
      int x = in.nextInt();
      String s = Integer.toBinaryString(x);
      while (s.length() < n)
        s = "0" + s;
      a[i] = s;
    }
    // System.out.println(Arrays.toString(a));
    String fedor = a[a.length - 1];
    for (int i = 0; i < a.length - 1; i++) {
      int temp_k = k;
      boolean friend = true;
      for (int j = 0; j < fedor.length(); j++) {
        if (fedor.charAt(j) != a[i].charAt(j))
          temp_k--;
        if (temp_k < 0)
          friend = false;
      }
      if (friend)
        c++;
    }
    System.out.println(c);
  }
}
