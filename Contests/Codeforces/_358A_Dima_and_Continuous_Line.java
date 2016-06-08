import java.util.Scanner;

public class _358A_Dima_and_Continuous_Line {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n - 1];
		int[] y = new int[n - 1];
		int l = in.nextInt();
		for (int i = 0; i < n - 1; i++) {
			int r = in.nextInt();
			x[i] = Math.min(r, l);
			y[i] = Math.max(r, l);
			l = r;
		}
		int a, b, c, d;
		for (int i = 0; i < n - 1; i++) {
			a = x[i];
			b = y[i];
			for (int j = i + 1; j < n - 1; j++) {
				c = x[j];
				d = y[j];
				if ((a > c && a < d && b != d) ^ (b > c && b < d && a != c)) {
					System.out.println("yes");
					return;
				}
			}
		}
		System.out.println("no");
	}
}
