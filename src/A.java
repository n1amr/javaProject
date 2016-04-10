import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n, t;

    n = in.nextInt();
    t = in.nextInt();

    double ans = (double) n;

    for (int i = 0; i < t; i++) {
      ans *= 1.000000011;
    }
    System.out.println(ans);
  }
}
