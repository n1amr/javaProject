import java.util.Arrays;
import java.util.Scanner;

public class _387B_George_and_Round {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[m];

		for (int i = 0; i < n; i++) 
			a[i] = in.nextInt();
		for (int i = 0; i < m; i++)
			b[i] = in.nextInt();
		Arrays.sort(a);
		Arrays.sort(b);

		int r = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (j < m && b[j] < a[i])
				j++;
			if (j < m && b[j] >= a[i]) {
				r++;
				j++;
			}
		}

		System.out.println(n - r);
	}
}
