import java.util.Scanner;

public class _550_C_Divisibility_by_Eight {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    String s = in.next();
    for (int i = 0; i <= 1000; i += 8) {
      if (isSub(s, Integer.toString(i), 0, 0)) {
        System.out.println("YES\n" + i);
        return;
      }
    }
    System.out.println("NO");
  }

  static boolean isSub(String all, String sub, int i, int j) {
    if (i >= all.length() || j >= sub.length())
      return false;

    if (all.charAt(i) == sub.charAt(j))
      return j == sub.length() - 1
          || isSub(all, sub, i + 1, j + 1);
    else
      return isSub(all, sub, i + 1, j);
  }
}
