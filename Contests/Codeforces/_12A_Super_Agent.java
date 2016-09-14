import java.util.Scanner;

public class _12A_Super_Agent {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[][] a = new char[3][];
    for (int i = 0; i < 3; i++)
      a[i] = in.nextLine().toCharArray();
    if (a[0][0] == a[2][2] && a[0][1] == a[2][1] && a[0][2] == a[2][0] && a[1][0] == a[1][2])
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
