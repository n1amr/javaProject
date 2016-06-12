import java.util.Scanner;

public class _371A_K_Periodic_Array {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		int r = 0;
		for (int i = 0; i < k; i++) {
			int n1 = 0;
			int n2 = 0;
			for (int j = i; j < a.length; j += k)
				if (a[j] == 1)
					n1++;
				else
					n2++;
			r += Math.min(n1, n2);
		}
		System.out.println(r);
	}
}
