import java.io.*;
import java.util.*;

public class _591C_Median_Smoothing {
    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
	boolean debug = true;
	boolean random = false;

	int n = 1;
	int[] c = { 0 };

	if (!debug) {
	    n = in.nextInt();
	    in.nextLine();
	    for (int i = 0; i < n; i++)
		c[i] = in.nextInt();

	} else {
	    n = 50;
	    if (random) {
		c = new int[n];
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
		    c[i] = r.nextBoolean() ? 1 : 0;
		}
	    } else {
		c = new int[] { 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0,
			0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 };
	    }
	}
	int[] corrrectans = { 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1 };
	int[] ans = new int[n];
	System.arraycopy(c, 0, ans, 0, n);
	System.out.println(Arrays.toString(c));
	System.out.println();

	for (int i = 1; i + 1 < n; i++) {
	    if (ans[i] != ans[i - 1]) {
		int p1 = i - 2;
		int p2 = i + 1;
		while (ans[p2] != ans[p2 - 1] && p2 < n)
		    p2++;

		System.out.println("from " + p1 + " to " + p2);
		while (p2 >= p1) {
		    if (p1 <= p2 && p1 >= 0 && p1 + 1 < ans.length) {
			ans[p1 + 1] = ans[p1];
			p1++;
		    }
		    if (p1 <= p2 && p2 - 1 >= 0 && p2 < ans.length) {
			ans[p2 - 1] = ans[p2];
			p2--;
		    }
		    check(i, ans, corrrectans);
		}
	    }
	    check(i, ans, corrrectans);
	}
	// ans[n - 2] = ans[n - 1] + ans[n - 2] + ans[n - 3] > 1 ? 1 : 0;

	System.out.println("My ans:");
	System.out.println(Arrays.toString(ans));
	System.out.println();
	int[] last = new int[c.length];
	System.arraycopy(c, 0, last, 0, c.length);

	boolean cont = true;
	int cnt = -1;
	while (cont) {
	    cnt++;
	    cont = false;
	    System.out.println(Arrays.toString(last));
	    for (int i = 1; i < c.length - 1; i++) {
		c[i] = (last[i] + last[i - 1] + last[i + 1] > 1) ? 1 : 0;
		if (c[i] != last[i])
		    cont = true;
	    }
	    System.arraycopy(c, 0, last, 0, c.length);
	}

	System.out.println(cnt);
	System.out.println(Arrays.toString(c));

	System.out.println(Arrays.equals(ans, c));

	out.close();
    }

    private static void check(int i, int[] ans, int[] corrrectans) {
	ans[i] = -ans[i] - 50;
	corrrectans[i] = -corrrectans[i] - 50;
	System.out.println(Arrays.toString(corrrectans));
	System.out.println(Arrays.toString(ans));
	System.out.println();
	ans[i] = -ans[i] - 50;
	corrrectans[i] = -corrrectans[i] - 50;
    }
}
