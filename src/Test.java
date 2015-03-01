import java.util.HashMap;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int w[] = new int[26];
	for (int i = 0; i < 26; i++)
	    w[i] = in.nextInt();
	String s = in.next();
	int n = s.length();

	long ans = 0;

	HashMap<Long, long[]> map = new HashMap<Long, long[]>();
	long sum[] = new long[n];
	long p[];
	for (int i = 0; i < n; i++) {
	    int cIndex = s.charAt(i) - 'a';
	    if (i == 0)
		sum[i] = w[cIndex];
	    else
		sum[i] = sum[i - 1] + w[cIndex];

	    if (i > 0 && map.containsKey(sum[i - 1])) {
		p = map.get(sum[i - 1]);
		ans += p[cIndex];
	    }
	    if (map.containsKey(sum[i]))
		p = map.get(sum[i]);
	    else
		p = new long[26];
	    p[cIndex]++;
	    map.put(sum[i], p);
	}
	System.out.println(ans);
    }
}