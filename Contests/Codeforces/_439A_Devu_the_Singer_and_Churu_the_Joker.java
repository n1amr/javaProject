import java.util.Scanner;

public class _439A_Devu_the_Singer_and_Churu_the_Joker {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int maxTime = in.nextInt();
    int s = 0;
    for (int i = 0; i < n; i++)
      s += in.nextInt();
    if (maxTime < s + (n - 1) * 10)
      System.out.println(-1);
    else
      System.out.println((maxTime - s) / 5);
  }
}
