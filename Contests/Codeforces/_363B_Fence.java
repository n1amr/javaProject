import java.util.Scanner;

public class _363B_Fence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		int index = 0;
		int sum = 0;
		int minSum = 0;

		for (int i = 0; i < k; i++)
			sum += a[i];
		minSum = sum;
		for (int i = 0; i + k < a.length; i++) {

			sum = sum - a[i] + a[i + k];
			if (minSum > sum) {
				minSum = sum;
				index = i + 1;
			}
		}

		System.out.println(index + 1);
	}
}
