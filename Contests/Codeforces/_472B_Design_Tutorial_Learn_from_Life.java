import java.util.Arrays;
import java.util.Scanner;

public class _472B_Design_Tutorial_Learn_from_Life {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		Arrays.sort(a);
		int r = 0;
		for (int i = a.length - 1; i >= 0; i -= k)
			r += 2 * (a[i] - 1);
		System.out.println(r);

	}
}
