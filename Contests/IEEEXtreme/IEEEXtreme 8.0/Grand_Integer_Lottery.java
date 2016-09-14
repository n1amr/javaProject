import java.util.Scanner;

public class Grand_Integer_Lottery {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long S = in.nextLong();
    long E = in.nextLong();
    long P = in.nextLong();
    long N = in.nextLong();
    int MAX = 25000000;
    boolean[] b = new boolean[MAX];
    for (long i = 0; i < N; i++) {
      long n1 = in.nextLong();
      String current = Long.toString(n1);
      for (int j = (int) n1; j < MAX; j++) {
        String test = Long.toString(j);
        if (test.contains(current))
          b[j] = true;
      }
    }
    long ans = 0;
    long r = 0;
    for (int i = 0; i < MAX; i++) {
      if (b[i])
        r++;
      if (r == P) {
        System.out.println(i);
        return;
      }
    }
    System.out.println("DFG");
  }
}
