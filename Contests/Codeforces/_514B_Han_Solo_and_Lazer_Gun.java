import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _514B_Han_Solo_and_Lazer_Gun {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int x0 = in.nextInt(), y0 = in.nextInt();
    Set<Double> s = new TreeSet<Double>();
    int x, y;
    Double slope;
    for (int i = 0; i < n; i++) {
      x = in.nextInt();
      y = in.nextInt();
      slope = 1.0 * (y - y0) / (x - x0);
      slope = slope == Double.NEGATIVE_INFINITY ? Double.POSITIVE_INFINITY : slope;
      slope = slope == -0.0 ? 0.0 : slope;
      s.add(slope);
    }
    System.out.println(s.size());
  }
}
