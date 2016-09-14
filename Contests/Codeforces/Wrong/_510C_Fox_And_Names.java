import java.util.Scanner;

public class _510C_Fox_And_Names {
  static boolean taken[];

  static boolean isTaken(char c) {
    return taken[c - 'a'];
  }

  static void take(char c) {
    taken[c - 'a'] = true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] name = new String[n];
    for (int i = 0; i < n; i++)
      name[i] = in.next();
    taken = new boolean[26];
    StringBuilder order = new StringBuilder();
    StringBuilder prefix = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String cur = name[i];
      String past = i == 0 ? name[0] : name[i - 1];
      char c;
      int p = prefix.length();
      if (i != 0) {
        boolean ex = false;
        while (cur.charAt(p) == past.charAt(p)) {
          prefix.append(cur.charAt(p));
          p++;
          ex = true;
          if (prefix.toString().equals(past))
            break;
        }

        if (ex)
          if (past.length() > p) {
            take(past.charAt(p));
            order.append(past.charAt(p));
          }
        while (prefix.length() > 0 && cur.charAt(p - 1) != past.charAt(p - 1)) {
          prefix.delete(p - 1, p);
          p--;
        }
      }
      c = cur.charAt(p);
      take(c);
      order.append(c);

    }
    for (char c = 'a'; c <= 'z'; c++)
      if (!isTaken(c))
        order.append(c);
    if (order.length() == 26)
      System.out.println(order);
    else
      System.out.println("Impossible");
  }
}
