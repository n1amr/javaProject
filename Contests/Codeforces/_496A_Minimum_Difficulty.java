import java.util.Scanner;

public class _496A_Minimum_Difficulty {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] diff = new int[n - 1];
		int n1 = in.nextInt(), n2 = 0;
		for (int i = 0; i < n - 1; i++) {
			n2 = in.nextInt();
			diff[i] = Math.abs(n1 - n2);
			n1 = n2;
		}
		int min = diff[0] + diff[1];
		int minIndex = 0;
		for (int i = 0; i < diff.length - 1; i++) {
			int v = diff[i] + diff[i + 1];
			if (min > v) {
				min = v;
				minIndex = i;
			}
		}
		diff[minIndex] = min;
		diff[minIndex + 1] = 0;
		int max = diff[0];
		for (int i = 0; i < diff.length; i++)
			max = Math.max(max, diff[i]);
		System.out.println(max);
	}
}