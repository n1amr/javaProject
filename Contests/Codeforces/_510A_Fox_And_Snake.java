import java.util.Scanner;

public class _510A_Fox_And_Snake {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		char[][] ans = new char[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				ans[i][j] = i % 2 == 0 || (i - 1) % 4 == 0 && j == m - 1 || (i - 3) % 4 == 0 && j == 0 ? '#'
								: '.';
		for (int i = 0; i < n; i++)
			System.out.println(new String(ans[i]));
	}
}
