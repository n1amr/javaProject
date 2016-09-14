import java.util.Scanner;

public class CookieParty {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int m = in.nextInt();

    System.out.println((n - m % n) % n);
  }
}