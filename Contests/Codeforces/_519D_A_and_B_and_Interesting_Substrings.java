import java.util.*;

public class _519D_A_and_B_and_Interesting_Substrings {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int[] w = new int[256];
	char c;
	for (c = 'a'; c <= 'z'; c++)
	    w[c] = in.nextInt();
	String s = in.next();
	long[] sum = new long[s.length()];
	HashMap<Character, HashMap<Long, Integer>> map = new HashMap<Character, HashMap<Long, Integer>>();
	for (c = 'a'; c <= 'z'; c++)
	    map.put(c, new HashMap<Long, Integer>());

	long ans = 0;

	for (int i = 0; i < s.length(); i++) {
	    c = s.charAt(i);
	    if (i > 0)
		sum[i] = sum[i - 1] + w[c];
	    else
		sum[i] = w[c];

	    HashMap<Long, Integer> m = map.get(c);
	    if (i > 0 && m.containsKey(sum[i - 1]))
		ans += m.get(sum[i - 1]);

	    if (m.containsKey(sum[i]))
		m.put(sum[i], m.get(sum[i]) + 1);
	    else
		m.put(sum[i], 1);
	}
	System.out.println(ans);
    }
}