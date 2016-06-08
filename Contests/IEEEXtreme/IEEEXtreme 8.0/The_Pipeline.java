import java.util.Arrays;
import java.util.Scanner;

public class The_Pipeline {
	static int[][] a;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = in.nextInt();
			}
		}
		mem = new int[n][n];
		isVisited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(mem[i], -1);
		}
		System.out.println(ans(1, 2));

		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(mem[i]));
		}
	}

	static int[][] mem;
	static boolean[][] isVisited;
	static int n;

	static boolean isVisited(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return true;
		}
		return isVisited[i][j];
	}

	static int ans(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return 0;
		}
		isVisited[i][j] = true;

		if (mem[i][j] != -1)
			return mem[i][j];

		int[] p = new int[4];

		if (!isVisited(i + 1, j))
			p[0] = ans(i + 1, j);

		if (!isVisited(i - 1, j))
			p[1] = ans(i - 1, j);

		if (!isVisited(i, j + 1))
			p[2] = ans(i, j + 1);

		if (!isVisited(i, j - 1))
			p[3] = ans(i, j - 1);

		// isVisited[i][j] = false;

		Arrays.sort(p);
		return mem[i][j] = a[i][j] + p[0];
	}
}
