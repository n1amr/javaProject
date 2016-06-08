import java.util.Scanner;

public class _279B_Books {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();

		int r = 0;
		int max = 0;
		long sum = 0;

		int i = 0;
		int j = 0;
		while (i < n && j < n) {
			while (j < n && sum + a[j] <= t) {
				r++;
				sum += a[j];
				j++;
			}

			while (sum > t) {
				r--;
				sum -= a[i];
				i++;
			}
			max = Math.max(max, r);

			sum -= a[i];
			i++;
			r--;
		}
		System.out.println(max);

	}
}