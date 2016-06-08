import static java.lang.Math.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class _446A_DZY_Loves_Sequences {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileInputStream(new File("input.txt")));
		// Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n + 1];
		a[0] = 0;
		mem = new int[2][];
		mem[0] = new int[n + 1];
		mem[1] = new int[n + 1];
		Arrays.fill(mem[0], -1);
		Arrays.fill(mem[1], -1);
		for (int i = 1; i <= n; i++)
			a[i] = in.nextInt();
		System.out.println(ans(a, 1, false, 0, 0));
	}

	static int[][] mem;

	static int ans(int[] a, int i, boolean c, int count, int lastChange) {
		if (i >= a.length)
			return count;
		if (mem[c ? 1 : 0][i] != -1)
			return mem[c ? 1 : 0][i];
		if (a[i] < a[i - 1])
			if (!c) {
				c = true;
				lastChange = i - 1;
			} else
				return mem[c ? 1 : 0][i] = count;
		int con = ans(a, i + 1, c, count + 1, lastChange);
		int stop = ans(a, lastChange, false, i - lastChange, lastChange);
		return mem[c ? 1 : 0][i] = max(con, stop);
	}
}
