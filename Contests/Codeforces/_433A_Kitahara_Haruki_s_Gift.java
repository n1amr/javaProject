import java.util.Scanner;

public class _433A_Kitahara_Haruki_s_Gift {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[3];
		String ans = "NO";
		for (int i = 0; i < n; i++)
			a[in.nextInt() / 100]++;

		if (a[1] % 2 == 0 && !(a[1] == 0 && a[2] % 2 == 1))
			ans = "YES";
		System.out.println(ans);
	}
}
