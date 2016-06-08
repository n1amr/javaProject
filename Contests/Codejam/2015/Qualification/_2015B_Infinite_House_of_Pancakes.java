import java.io.*;
import java.util.*;

//WRONG
public class _2015B_Infinite_House_of_Pancakes {
	public static Scanner in;
	public static PrintWriter out;
	public static int N = 11;

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
		int n = in.nextInt();
		int max = 0;
		int[] a = new int[N + 1];
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			a[x]++;
		}
		int r = rec(a, 0);
		out.println(r);
	}

	private static int rec(int[] a, int r) {
		int max = 0;
		for (int i = N; i >= 0; i--) {
			if (a[i] != 0) {
				max = i;
				break;
			}
		}
		if (max == 0)
			return r;
		int r1 = rec(eat(a), r + 1);
		if (max < 2)
			return r1;

		int r2 = rec(splitMax(a, max), r + 1);

		return Math.min(r1, r2);
	}

	static int[] eat(int[] a) {
		int[] s1 = new int[N + 1];
		for (int i = 0; i < N; i++) {
			s1[i] = a[i + 1];
		}
		return s1;
	}

	static int[] splitMax(int[] a, int max) {
		int[] s2 = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			s2[i] = a[i];
		}
		int q = max - max / 2;
		int w = max / 2;
		s2[max]--;
		s2[q]++;
		s2[w]++;
		return s2;
	}
}
