import java.util.Scanner;

public class _471C_MUH_and_House_of_Cards {
	static long[] standard;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		int x = buildStandard(n);
		int r = 0;
		// System.out.println(Arrays.toString(standard));

		for (int i = 1; i <= x; i++)
			if ((n - standard[i]) % 3 == 0 && n >= standard[i])
				r++;
		// System.out.println(i);
		System.out.println(r);
	}

	private static int buildStandard(long n) {
		int MAX = 1000000;
		standard = new long[MAX];
		long last = 2;
		for (int i = 1; i < MAX; i++) {
			standard[i] = last;
			if (last > n)
				return i;
			last = last + (i + 1) * 3 - 1;
		}
		return MAX;

	}
}
