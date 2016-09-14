import java.util.Scanner;

public class _369A_Valera_and_Plates {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int nBowls = in.nextInt();
    int nPlates = in.nextInt();
    int a;
    int r = 0;
    for (int i = 0; i < n; i++) {
      a = in.nextInt();
      if (a == 1) {
        if (nBowls > 0)
          nBowls--;
        else
          r++;

      } else if (nPlates > 0)
        nPlates--;
      else if (nBowls > 0)
        nBowls--;
      else
        r++;
    }
    System.out.println(r);
  }
}
