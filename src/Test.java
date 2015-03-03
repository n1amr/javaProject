import java.util.HashMap;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int[] w = new int[256];
	for (int i = 'a'; i <= 'z'; i++)
	    w[i] = in.nextInt();
	String s = in.next();
	char c;
	long sum[] = new long[s.length()];
	HashMap<Character, HashMap<Long, Long>> mp = new HashMap<Character, HashMap<Long, Long>>();
	for (c = 'a'; c <= 'z'; c++)
	    mp.put(c, new HashMap<Long, Long>());

	long ans = 0;

	long p;
	for (int i = 0; i < s.length(); i++) {
	    c = s.charAt(i);
	    if (i > 0)
		sum[i] = sum[i - 1] + w[c];
	    else
		sum[i] = w[c];

	    HashMap<Long, Long> m = mp.get(c);
	    if (i > 0 && m.containsKey(sum[i - 1])) {
		p = m.get(sum[i - 1]);
		ans += p;
	    }
	    if (m.containsKey(sum[i]))
		p = m.get(sum[i]);
	    else
		p = 0;
	    p++;
	    m.put(sum[i], p);
	}
	System.out.println(ans);
    }
}