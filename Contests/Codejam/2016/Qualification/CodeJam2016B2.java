import java.io.*;
import java.util.*;

public class CodeJam2016B2 {
	public static Scanner in;
	public static PrintWriter out;

	public static void main(String[] args) throws FileNotFoundException {
		initialize();
		in = new Scanner(new BufferedInputStream(new FileInputStream(new File("B-small-attempt0.in"))));
		out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File("output.txt"))));
		int nCases = in.nextInt();
		in.nextLine();
		for (int CASE = 1; CASE <= nCases; CASE++) {
			out.print("Case #" + CASE + ": ");
			solve();
		}
		out.close();
		System.err.println("Done");
	}

	static int[] c;
	static int length = 25;

	static void initialize() {
		c = new int[1 << length];
		for (int i = 0; i < c.length; i++)
			c[i] = Integer.MAX_VALUE;
		c[(1 << length) - 1] = 0;

		int n, n2;

		Stack<Integer> s = new Stack<Integer>();
		s.push((1 << length) - 1);
		while (!s.empty()) {
			n = s.pop();
			for (int i = 1; i <= length; i++) {
				n2 = flip(n, i);
				if (c[n2] > c[n] + 1) {
					c[n2] = c[n] + 1;
					s.push(n2);
				}
			}
		}
	}

	static void solve() {
		String s = in.next();
		int n = 0;
		for (int i = 0; i < length - s.length(); i++) {
			n <<= 1;
			n |= 1;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			n <<= 1;
			n |= (s.charAt(i) == '+') ? 1 : 0;
		}
		out.println(c[n]);
	}

	static int flip(int stack, int count) {
		int tmpstack1 = 0;
		int tmpstack2 = 0;
		int n = 0;
		int i = 0;
		while (i < count) {
			tmpstack1 <<= 1;
			tmpstack1 |= (stack % 2) ^ 1;
			stack = stack >> 1;
			i++;
		}
		i = 0;
		while (i < count) {
			tmpstack2 <<= 1;
			tmpstack2 |= tmpstack1 % 2;
			tmpstack1 >>= 1;
			i++;
		}
		i = 0;
		while (i < count) {
			stack = stack << 1 | (tmpstack2 % 2);
			tmpstack2 >>= 1;
			i++;
		}
		return stack;
	}
}
