import java.util.Scanner;

public class HKNProblem {

  boolean[] taken = new boolean[21];

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] se = input.nextLine().split(",");
    int start = Integer.parseInt(se[0]);
    int end = Integer.parseInt(se[1]);
    int count = 0;
    for (int i = start; i <= end; i++) {
      String bin = Integer.toBinaryString(i);
      String revbin = rev(bin);

      if (isEqual(bin, revbin))
        count++;
    }
    System.out.println(count);
  }

  private static boolean isEqual(String s1, String s2) {
    for (int i = 0; i < s1.length(); i++)
      if (s1.charAt(i) != s2.charAt(i))
        return false;
    return true;
  }

  public static String rev(String str) {
    char[] s = str.toCharArray();
    int n = s.length;
    int halfLength = n / 2;
    for (int i = 0; i < halfLength; i++) {
      char temp = s[i];
      s[i] = s[n - 1 - i];
      s[n - 1 - i] = temp;
    }
    return new String(s);
  }
}
