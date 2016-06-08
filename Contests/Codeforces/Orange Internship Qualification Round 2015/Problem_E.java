import java.util.Scanner;

public class Problem_E {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		for (int test = 0; test < T; test++) {
			int n = in.nextInt();
			long max = 0;
			long ans = 0;
			for (int k = 0; k < n; k++) {
				long cur = in.nextLong();
				if (max > cur)
					ans += max - cur;
				max = cur;
			}
			System.out.println(ans);
		}
	}
}
