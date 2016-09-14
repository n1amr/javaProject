import java.util.Scanner;

public class _289A_Polo_the_Penguin_and_Segments {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), k = in.nextInt(), c = 0;
    for (int i = 0; i < n; i++)
      c += 1 - in.nextInt() + in.nextInt();
    System.out.println((k - c % k) % k);
  }
}