import java.util.Scanner;

public class _158B_Taxi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[5];
		for (int i = 0; i < n; i++)
			a[in.nextInt()]++;
		int r = a[4];

		r += a[3];
		if (a[1] >= a[3])
			a[1] = a[1] - a[3];
		else
			a[1] = 0;

		r += a[2] / 2;
		if (a[2] % 2 != 0) {
			r++;
			if (a[1] >= 2)
				a[1] -= 2;
			else
				a[1] = 0;
		}
		r += (a[1] + 3) / 4;

		System.out.println(r);
	}
}
