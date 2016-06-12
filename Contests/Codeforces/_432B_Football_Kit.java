import java.util.Scanner;

public class _432B_Football_Kit {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] home = new int[n];
		int[] abroad = new int[n];
		int[] colorCount = new int[100005];

		for (int i = 0; i < n; i++) {
			home[i] = in.nextInt();
			abroad[i] = in.nextInt();
			colorCount[home[i]]++;
		}

		for (int i = 0; i < n; i++) {
			int x = n - 1 + colorCount[abroad[i]];
			System.out.println(x + " " + (2 * n - 2 - x));
		}

	}
}