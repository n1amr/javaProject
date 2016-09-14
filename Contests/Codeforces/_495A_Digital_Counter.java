import java.util.Scanner;

public class _495A_Digital_Counter {
  public static void main(String[] args) {
    char[] s = new Scanner(System.in).next().toCharArray();
    int[] a = {2, 7, 2, 3, 3, 4, 2, 5, 1, 2};
    System.out.println(a[s[0] - '0'] * a[s[1] - '0']);
  }
}