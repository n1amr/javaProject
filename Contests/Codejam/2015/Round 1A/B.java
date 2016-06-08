import java.io.*;
import java.util.*;

public class B {
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
			System.out.println("Case #" + CASE);
			solve();
		}
		out.close();
		System.err.println("Done");
	}

	static void solve() {
		int B = in.nextInt();
		int N = in.nextInt();
		int[] b = new int[B];
		long[] t = new long[B];
		for (int i = 0; i < B; i++)
			b[i] = in.nextInt();
		int m = 0;
		while (m != N) {
			int i = minIndex(t);
			t[i] += b[i];
			m++;
			if (m == N) {
				System.out.println(Arrays.toString(t));
				System.out.println(i + 1);
				out.println(i + 1);
				return;
			}

		}
		System.out.println(Arrays.toString(t));
	}

	static int minIndex(long[] a) {
		int r = 0;
		long min = a[0];

		for (int i = 0; i < a.length; i++)
			if (a[i] < min) {
				min = a[i];
				r = i;
			}
		return r;
	}
}
