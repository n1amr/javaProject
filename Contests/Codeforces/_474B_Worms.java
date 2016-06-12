import java.util.Scanner;

public class _474B_Worms {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		a[0] = in.nextLong();
		for (int i = 1; i < n; i++)
			a[i] = in.nextLong() + a[i - 1];
		int q = in.nextInt();
		while (q-- != 0)
			System.out.println(BS(a, in.nextInt()) + 1);
	}

	static int BS(long[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + high >> 1;
			long midVal = a[mid];
			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid;
		}
		return low;
	}
}
