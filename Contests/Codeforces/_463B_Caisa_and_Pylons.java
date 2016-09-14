import java.util.Scanner;

public class _463B_Caisa_and_Pylons {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int max = 0;
    for (int i = 0; i < n; i++)
      max = Math.max(max, in.nextInt());
    System.out.println(max);
  }
}
