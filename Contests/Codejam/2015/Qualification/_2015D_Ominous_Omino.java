import java.io.*;
import java.util.*;

public class _2015D_Ominous_Omino {
	public static Scanner in;
	public static PrintWriter out;

	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new BufferedInputStream(new FileInputStream(new File(
						"input.txt"))));
		out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(
						new File("output.txt"))));
		int nCases = in.nextInt();
		in.nextLine();
		for (int CASE = 1; CASE <= nCases; CASE++) {
			out.print("Case #" + CASE + ": ");
			solve();
		}
		out.close();
		System.err.println("Done");
	}

	static void solve() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					ans(i + 1, j + 1, k + 1);
				}
			}
		}
		if (ans(in.nextInt(), in.nextInt(), in.nextInt()))
			out.println("GABRIEL");
		else
			out.println("RICHARD");
	}

	private static boolean ans(int i, int j, int k) {
		if (j > k) {
			int tmp = k;
			k = j;
			j = tmp;
		}
		if (j * k % i != 0)
			return false;
		if (i < 3)
			return true;
		boolean ans = false;
		ans |= (i == 3) && (j == 2) && (k == 3);
		ans |= (i == 3) && (j == 3) && (k == 3);
		ans |= (i == 3) && (j == 3) && (k == 4);
		ans |= (i == 4) && (j == 3) && (k == 4);
		ans |= (i == 4) && (j == 4) && (k == 4);
		return ans;
	}
}
