import java.util.Scanner;

public class _102B_Sum_of_Digits {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String n = in.next();
    int r = 0;
    while (n.length() > 1) {
      n = Integer.toString(sumOfDigits(n));
      r++;
    }
    System.out.println(r);
  }

  static int sumOfDigits(String n) {
    int sum = 0;
    for (int i = 0; i < n.length(); i++)
      sum += n.charAt(i) - '0';
    return sum;
  }
}
