import java.util.Scanner;

public class _192A_Funky_Numbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int limit = (int) Math.sqrt(n);
		for (int i = 1; i <= limit; i++) {
			long a = f(i);
			long b = n - a;
			if (search(b)) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	private static boolean search(long b) {
		int start = 0;
		int end = 100000;
		int mid = 0;
		while (end - start > 1) {
			mid = (start + end) / 2;
			if (b > f(mid)) {
				start = mid;
			} else if (b < f(mid)) {
				end = mid;
			} else
				return b == f(mid);
		}
		return false;

	}

	static long f(long n) {
		return n * (n + 1) / 2;
	}
}
