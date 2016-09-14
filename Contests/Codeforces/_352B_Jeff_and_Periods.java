import java.util.LinkedList;
import java.util.Scanner;

public class _352B_Jeff_and_Periods {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();
    int c = 0;
    StringBuilder s = new StringBuilder();

    LinkedList[] l = new LinkedList[100001];
    for (int i = 0; i < a.length; i++) {
      if (l[a[i]] == null)
        l[a[i]] = new LinkedList();
      l[a[i]].add(i);
    }
    for (int i = 0; i < l.length; i++) {
      boolean v = true;
      if (l[i] == null)
        continue;
      int last = -1;
      int p = 0;
      for (Object o : l[i]) {
        Integer x = (Integer) o;
        if (last == -1)
          last = x;
        if (p == 0)
          p = x - last;
        if (p != x - last)
          v = false;
        last = x;
      }
      if (v) {
        c++;
        s.append(i + " " + p + "\n");
      }
    }
    System.out.println(c + "\n" + s);
  }
}
