import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _479C_Exams {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Point[] a = new Point[n];
    for (int i = 0; i < n; i++)
      a[i] = new Point(in.nextInt(), in.nextInt());
    Arrays.sort(a, new Comparator<Point>() {
      public int compare(Point o1, Point o2) {
        return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
      }
    });
    int l = Math.min(a[0].x, a[0].y);
    for (int i = 1; i < a.length; i++)
      if (l <= a[i].y)
        l = a[i].y;
      else
        l = a[i].x;
    System.out.println(l);
  }
}