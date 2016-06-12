import java.util.Scanner;

public class _448D_Multiplication_Table {
	static long n, m, k;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextLong();
		m = in.nextLong();
		k = in.nextLong();
		long r = ans();

		System.out.println(r);
	}

	private static long ans() {
		long start = 1;
		long mid = 0;
		long end = n * m + 1;
		while (end - start > 0) {
			mid = start + end >> 1;
			if (k > f(mid))
				start = mid + 1;
			else if (k <= f(mid))
				end = mid;
		}
		return start - 1;
	}

	private static long f(long x) {
		long sum = 0;
		for (int i = 0; i < n; i++)
			sum += Math.min(m, (x - 1) / (i + 1));
		return sum;
	}
}

/*
 * Solution is binary search by answer. We need to find largest x such that
 * amount of numbers from table, least than x, is strictly less than k.
 *
 * To calculate this count we sum counts from rows. In i th row there will be
 * min(m, (x - 1) / (i + 1)).
 *
 * Total complexity is O(nlog(nm)).
 */
