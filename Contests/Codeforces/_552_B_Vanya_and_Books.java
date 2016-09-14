import java.util.Scanner;

public class _552_B_Vanya_and_Books {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long s = n;
    int x = 9;
    while (n > x) {
      s += n - x;
      x = x * 10 + 9;
    }
    System.out.println(s);
  }
}
