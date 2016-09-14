import java.util.Scanner;

public class _501A_Contest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double a = in.nextInt();
    double b = in.nextInt();
    double c = in.nextInt();
    double d = in.nextInt();
    a = (int) Math.max(3.0 * a / 10, a * (1 - c / 250.0));
    b = (int) Math.max(3.0 * b / 10, b * (1 - d / 250.0));
    String ans = "Tie";
    if (a > b)
      ans = "Misha";
    else if (a < b)
      ans = "Vasya";
    System.out.println(ans);
  }
}
