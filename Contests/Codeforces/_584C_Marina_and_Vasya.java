import java.util.Scanner;

public class _584C_Marina_and_Vasya {
  public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  public static void main(String[] args) {
    int n = in.nextInt();
    int reqDiff = in.nextInt();
    char[] s1 = in.next().toCharArray();
    char[] s2 = in.next().toCharArray();

    char[] s3 = new char[n];
    System.arraycopy(s1, 0, s3, 0, n);

    int diff = 0;
    for (int i = 0; i < n; i++)
      if (s1[i] != s2[i])
        diff++;

    int swings, chSim, chDiff;
    if (reqDiff < diff) {
      chSim = 0;
      swings = diff - reqDiff;
      chDiff = reqDiff - swings;
    } else {
      swings = 0;
      chDiff = diff;
      chSim = reqDiff - diff;
    }

    int minDiff = (diff + 1) / 2;
    if (reqDiff < minDiff || reqDiff > n)
      out.println(-1);
    else {
      boolean half = false;
      for (int i = 0; i < n; i++)
        if (s1[i] != s2[i]) {
          if (swings != 0) {
            if (!half) {
              s3[i] = s1[i];
              half = true;
            } else {
              s3[i] = s2[i];
              half = false;
              swings--;
            }
          } else if (chDiff != 0) {
            s3[i] = differentChar(s1[i], s2[i]);
            chDiff--;
          }
        } else if (s1[i] == s2[i] && chSim != 0) {
          s3[i] = differentChar(s1[i], s2[i]);
          chSim--;
        }
      out.println(s3);
    }
    out.close();
  }

  static char differentChar(char a, char b) {
    char c = a != 'z' ? (char) (a + 1) : 'a';
    if (b == c)
      c = b != 'z' ? (char) (b + 1) : 'a';
    return c;
  }
}