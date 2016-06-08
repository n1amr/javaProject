import java.util.Scanner;

public class Elementary_Cellular_Automaton {
	static int N;
	static int rule;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		rule = in.nextInt();
		int k = in.nextInt();
		N = in.nextInt();
		long init = in.nextLong();

		table = toBinaryArr(rule, 8);

		boolean[] b = toBinaryArr(init, N);
		boolean[] c = b;
		for (int i = 0; i < k; i++) {
			String lineNumber = Integer.toString(i + 1);
			while (lineNumber.length() < 4)
				lineNumber += ' ';
			System.out.print(lineNumber);
			print(c);
			c = step(b);
			b = c;
		}
	}

	static void print(boolean[] c) {
		System.out.print('-');
		for (int i = 0; i < c.length; i++) {
			if (c[i])
				System.out.print('*');
			else
				System.out.print(' ');
		}
		System.out.print('-');
		System.out.println();
	}

	static boolean[] step(boolean[] b) {

		boolean[] c = new boolean[N];
		c[0] = v(false, b[0], b[1]);
		for (int i = 1; i < N - 1; i++) {
			c[i] = v(b[i - 1], b[i], b[i + 1]);
			// System.out.println(Arrays.toString(c));
		}
		c[N - 1] = v(b[N - 2], b[N - 1], false);
		// System.out.println(Arrays.toString(c));
		return c;
	}

	static boolean[] toBinaryArr(long n, int N) {
		boolean[] b = new boolean[N];
		String bs = Long.toBinaryString(n);
		int offset = N - bs.length();
		for (int i = 0; i < bs.length(); i++) {
			b[i + offset] = bs.charAt(i) == '1';
		}
		return b;
	}

	static boolean[] table;

	private static boolean v(boolean a, boolean b, boolean c) {
		int digit = 0;
		if (!c)
			digit += 1;
		if (!b)
			digit += 2;
		if (!a)
			digit += 4;
		return table[digit];
	}
}
