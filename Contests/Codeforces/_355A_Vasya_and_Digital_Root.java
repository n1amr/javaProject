import java.util.Scanner;

public class _355A_Vasya_and_Digital_Root {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int k = in.nextInt();
    int d = in.nextInt();
    if (k > 1 && d == 0)
      System.out.println("No solution");
    else {
      System.out.print(d);
      if (k-- != 0)
        while (k-- != 0)
          System.out.print(0);
    }
  }
}
