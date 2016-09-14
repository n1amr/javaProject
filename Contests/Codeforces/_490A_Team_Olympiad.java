import java.util.ArrayList;
import java.util.Scanner;

public class _490A_Team_Olympiad {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ArrayList[] arr = new ArrayList[3];
    int[] c = new int[3];
    for (int i = 0; i < 3; i++)
      arr[i] = new ArrayList();
    int min = 9999;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      c[x - 1]++;
      arr[x - 1].add(i + 1);
    }
    for (int i = 0; i < 3; i++)
      min = Math.min(min, c[i]);

    System.out.println(min);
    for (int i = 0; i < min; i++)
      System.out.println(arr[0].get(i) + " " + arr[1].get(i) + " " + arr[2].get(i));
  }
}
