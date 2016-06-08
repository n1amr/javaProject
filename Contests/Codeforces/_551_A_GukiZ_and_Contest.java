import java.io.*;
import java.util.*;

public class _551_A_GukiZ_and_Contest {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		for (int i = 0; i < n; i++) {
			int x = 1;
			for (int j = 0; j < n; j++)
				if(a[j] > a[i])
					x++;
			out.print(x + " ");
		}
		out.println();
		out.close();
	}
}
