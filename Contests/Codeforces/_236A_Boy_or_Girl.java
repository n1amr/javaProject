import java.util.Scanner;

public class _236A_Boy_or_Girl {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    boolean[] a = new boolean[26];
    int c = 0;
    for (int i = 0; i < s.length(); i++) {
      int p = s.charAt(i) - 'a';
      if (!a[p]) {
        c++;
        a[p] = true;
      }
    }
    if (c % 2 == 0)
      System.out.println("CHAT WITH HER!");
    else
      System.out.println("IGNORE HIM!");
  }
}
