import java.util.Scanner;

public class _471D_MUH_and_Cube_Walls {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int w = in.nextInt();

		int[] a = new int[n];
		int[] b = new int[w];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		for (int i = 0; i < w; i++)
			b[i] = in.nextInt();

		int[] A = new int[n];
		int[] B = new int[w];
		for (int i = 1; i < n; i++)
			A[i] = a[i] - a[i - 1];
		for (int i = 1; i < w; i++)
			B[i] = b[i] - b[i - 1];
		// System.out.println(Arrays.toString(B));
		int r = 0;

		for (int i = 1; i < n; i++)
			if (A[i] == B[1]) {
				boolean s = true;
				for (int k = 0; k < B.length; k++)
					if (i + k < A.length && 1 + k < B.length
							&& A[i + k] != B[k + 1])
						s = false;
				if (s)
					r++;
			}

		System.out.println(r);
		in.close();
	}
}
