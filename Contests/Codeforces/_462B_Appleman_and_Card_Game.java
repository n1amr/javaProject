import java.util.*;

public class _462B_Appleman_and_Card_Game {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	long k = in.nextInt();
	long[] a = new long[26];
	String s = in.next();
	for (int i = 0; i < s.length(); i++) {
	    a[s.charAt(i) - 'A']++;
	}

	long r = 0;
	while (k > 0) {
	    // Find max
	    long max = 0;
	    int maxIndex = 0;
	    for (int i = 0; i < 26; i++) {
		if (max < a[i]) {
		    max = a[i];
		    maxIndex = i;
		}
	    }
	    if (max <= k) {
		long toAdd = max * max;
		r += toAdd;
		k -= max;
		a[maxIndex] = 0;
	    } else {
		r += k * k;
		k = 0;
	    }
	}
	System.out.println(r);
    }
}
