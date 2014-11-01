import java.util.*;

public class _455A_Boredom {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[100001];
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			a[x]++;
		}
		int m = 100001;
		long[] DP = new long[m];
		DP[0] = 0;
		DP[1] = a[1];
		for (int i = 2; i < m; i++) {
			DP[i] = Math.max(DP[i - 1], DP[i - 2] + (long) a[i] * i);
		}
		System.out.println(DP[m - 1]);
	}
}
