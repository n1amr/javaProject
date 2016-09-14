import java.util.Scanner;

public class _453A_Little_Pony_and_Expected_Maximum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    double sum = 0;
    for (int i = 1; i <= m; i++)
      sum += i * (Math.pow((double) i / m, n) - Math.pow((double) (i - 1) / m, n));
    System.out.println(sum);
  }
}