import java.util.*;

public class _675_A_Infinite_Sequence {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    boolean bool = (a == b)
        || (c != 0 && Math.abs(a - b) % c == 0 && (c > 0 && b > a || c < 0 && b < a));
    System.out.println(bool ? "YES" : "NO");
  }
}
