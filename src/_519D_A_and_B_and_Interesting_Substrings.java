import java.io.*;
import java.util.*;

public class _519D_A_and_B_and_Interesting_Substrings {
    public static void main(String[] args) {
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
		System.in)));

	int[] weight = new int[256];
	for (int i = 0; i < 26; i++)
	    weight[i + 'a'] = in.nextInt();
	String s = in.next();

	long[] sum = new long[s.length()];
	TreeMap<Character, TreeMap<Long, Integer>> mp = new TreeMap<Character, TreeMap<Long, Integer>>();
	for (int i = 0; i < 26; i++)
	    mp.put((char) ('a' + i), new TreeMap<Long, Integer>());

	long ans = 0;
	char c = s.charAt(0);

	sum[0] = weight[c];
	for (int i = 1; i < s.length(); i++) {
	    c = s.charAt(i);
	    sum[i] = weight[c] + sum[i - 1];
	}

	// mp.get(c).add(0);
	for (int i = 1; i < s.length(); i++) {
	    c = s.charAt(i);
	    ans += mp.get(c).get(sum[i - 1]);
	    mp.get(c).put(sum[i], 1);
	}

	System.out.println(ans);
    }

}