import java.io.*;
import java.util.*;

public class _567_A_Lineland_Mail {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();

		for (int i = 0; i < n; i++) {
			int min, max;
			if (i == 0) {
				min = a[1] - a[0];
				max = a[n - 1] - a[0];
			} else if (i == n - 1) {
				min = a[n - 1] - a[n - 2];
				max = a[n - 1] - a[0];
			} else {
				min = Math.min(a[i] - a[i - 1], a[i + 1] - a[i]);
				max = Math.max(a[i] - a[0], a[n - 1] - a[i]);
			}
			out.println(min + " " + max);
		}

		out.close();
	}
}
