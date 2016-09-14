import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class _591B_Rebranding {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    in.nextInt();
    int m = in.nextInt();
    in.nextLine();

    char[] s = in.nextLine().toCharArray();

    ArrayList<LinkedList<Integer>> mp = new ArrayList<LinkedList<Integer>>(26);
    for (char c = 0; c < 26; c++)
      mp.add(new LinkedList<Integer>());

    for (int i = 0; i < s.length; i++)
      mp.get(s[i] - 'a').add(i);

    LinkedList<Integer> temp;
    for (int i = 0; i < m; i++) {
      String inp = in.nextLine();
      int c1 = inp.charAt(0) - 'a';
      int c2 = inp.charAt(2) - 'a';
      temp = mp.get(c1);
      mp.set(c1, mp.get(c2));
      mp.set(c2, temp);
    }

    for (char c = 'a'; c <= 'z'; c++) {
      temp = mp.get(c - 'a');
      for (Integer p : temp)
        s[p] = c;
    }
    System.out.println(s);
  }
}
