import java.util.Scanner;

public class _4A_Watermelon {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if (n % 2 == 0 && n != 2)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
