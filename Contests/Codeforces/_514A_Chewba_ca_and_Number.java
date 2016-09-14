import java.util.Scanner;

public class _514A_Chewba_ca_and_Number {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] s = in.next().toCharArray();
    for (int i = 0; i < s.length; i++)
      if (s[i] > 0x34 && !(i == 0 && s[i] == '9'))
        s[i] = (char) (0x39 - s[i] + 0x30);
    System.out.println(new String(s));
  }
}
