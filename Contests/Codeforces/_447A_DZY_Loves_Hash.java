import java.util.Scanner;

public class _447A_DZY_Loves_Hash {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int n = in.nextInt();
		boolean[] a = new boolean[p];
		for (int i = 0; i < n; i++) {
			int k = in.nextInt() % p;
			if (a[k] == true) {
				System.out.println(i + 1);
				return;
			}
			a[k] = true;
		}
		System.out.println(-1);
	}
}
