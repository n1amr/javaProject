import java.io.*;
import java.util.*;

public class A {
	public static Scanner in;
	public static PrintWriter out;

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new BufferedInputStream(new FileInputStream(new File(
						"input.txt"))));
		out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(
						new File("output.txt"))));
		int nCases = in.nextInt();
		in.nextLine();
		for (int CASE = 1; CASE <= nCases; CASE++) {
			out.print("Case #" + CASE + ": ");
			solve();
		}
		out.close();
		System.err.println("Done");
	}

	static void solve() {
		long N = in.nextLong();
		long r = f(1, N);
		// long r = 1;
		// long c = 1;
		// while (c < N) {
		// long c1 = c + 1;
		// long c2 = flip(c);
		// if (c2 > N || c2 <= c) {
		// c = c1;
		// } else
		// c = Math.max(c1, c2);
		// r++;
		// }
		System.out.println(r);
		out.println(r);
	}

	static long f(long c, long n) {
		if (c == n)
			return 1;

		long r1 = f(c + 1, n);
		long c2 = flip(c);
		if (c2 > n || c2 <= c)
			return 1 + r1;
		long r2 = f(c2, n);

		return 1 + Math.min(r1, r2);
	}

	static long flip(long n) {
		String s = Long.toString(n);
		String s2 = (new StringBuffer(s)).reverse().toString();
		return Long.valueOf(s2);
	}
}
