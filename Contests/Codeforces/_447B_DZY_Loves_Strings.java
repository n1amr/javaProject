import java.util.Scanner;

public class _447B_DZY_Loves_Strings {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String s = in.next();
	int k = in.nextInt();
	int maxW = 0;
	int[] w = new int[26];
	for (int i = 0; i < 26; i++) {
	    w[i] = in.nextInt();
	    if (maxW < w[i]) {
		maxW = w[i];
	    }
	}
	int n = s.length();
	long valueBefore = 0;
	for (int i = 0; i < n; i++)
	    valueBefore += (i + 1) * w[s.charAt(i) - 'a'];
	// start n+1
	// end n+k
	// count k
	System.out.println(valueBefore + (long) maxW * k * (2 * n + k + 1) / 2);
    }
}
