import java.util.Scanner;

public class _158A_Next_Round {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		int r = 0;
		int i = 0;
		for (; i < a.length && i < k; i++) {
			if (a[i] == 0)
				break;
			r++;
		}
		i = k - 1;
		while (i + 1 < a.length && a[i + 1] != 0 && a[i] == a[i++ + 1])
			r++;

		System.out.println(r);
	}
}
