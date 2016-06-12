import java.util.Scanner;

public class _499A_Watching_a_movie {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();
		long a = 0;
		int c = 1;
		for (int i = 0; i < n; i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			while (c + x <= l)
				c += x;
			a += r - c + 1;
			c = r + 1;
		}
		System.out.println(a);
	}
}