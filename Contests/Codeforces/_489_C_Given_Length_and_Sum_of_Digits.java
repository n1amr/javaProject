import java.util.Scanner;

public class _489_C_Given_Length_and_Sum_of_Digits {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int length = in.nextInt();
    int sum = in.nextInt();

    System.out.println(min(length, sum) +
        " " +
        max(length, sum));
  }

  static String min(int length, int sum) {
    if (length == 1) {
      if (sum < 10)
        return "" + sum;
      else
        return "-1";
    }
    String min = "";
    for (int i = 0; i < length; i++) {
      for (int d = 0; d <= 9; d++) {
        if ((d > 0 || i > 0) && valid(length - i - 1, sum - d)) {
          min = min + "" + d;
          sum -= d;
          break;
        }
      }
    }
    if (min.length() == 0 || min.charAt(0) == '0')
      return "-1";
    return min;
  }

  static String max(int length, int sum) {
    if (length == 1) {
      if (sum < 10)
        return "" + sum;
      else
        return "-1";
    }
    String max = "";
    for (int i = 0; i < length; i++) {
      for (int d = 9; d >= 0; d--) {
        if ((d > 0 || i > 0) && valid(length - i - 1, sum - d)) {
          max = max + "" + d;
          sum -= d;
          break;
        }
      }
    }
    if (max.length() == 0 || max.charAt(0) == '0')
      return "-1";
    return max;
  }

  static boolean valid(int length, int sum) {
    return sum >= 0 && sum <= length * 9;
  }
}
