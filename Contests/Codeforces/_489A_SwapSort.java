import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class _489A_SwapSort {
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		HashMap<Integer, ArrayList<Integer>> c = new HashMap<Integer, ArrayList<Integer>>();
		StringBuilder ans = new StringBuilder();
		int k = 0;
		for (int i = 0; i < n; i++) {
			a[i] = b[i] = in.nextInt();
			if (!c.containsKey(a[i]))
				c.put(a[i], new ArrayList<Integer>());
			c.get(a[i]).add(i);
		}
		Arrays.sort(b);

		for (int i = 0; i < n; i++)
			if (a[i] != b[i]) {
				int l = i;
				int r;
				int p = 0;
				while (c.get(b[i]).get(p) < l)
					p++;
				r = c.get(b[i]).get(p);
				ans.append(l + " " + r + "\n");
				k++;
				c.get(a[i]).remove(new Integer(l));
				c.get(a[i]).add(r);

				c.get(b[i]).remove(new Integer(r));
				c.get(b[i]).add(l);

				int t = a[l];
				a[l] = a[r];
				a[r] = t;
			}
		System.out.println(k + "\n" + ans);
	}
}