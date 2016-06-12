import java.io.*;
import java.util.*;

public class CopyOfB {
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
		int B = in.nextInt();
		int N = in.nextInt();
		int[] b = new int[B];
		int max = 0;
		for (int i = 0; i < B; i++) {
			b[i] = in.nextInt();
			max = Math.max(max, b[i]);
		}
		max *= N + 5;
		int m = 0;
		TreeMap<Integer, ArrayList<Integer>> a = new TreeMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < B; i++) {
			int MAXa = max / b[i] + 1;
			for (int j = 0; j < MAXa; j++) {
				if (!a.containsKey(j * b[i]))
					a.put(j * b[i], new ArrayList<Integer>());
				a.get(j * b[i]).add(i);
			}
		}
		for (Integer i : a.keySet())
			if (a.containsKey(i))
				if (m + a.get(i).size() < N)
					m += a.get(i).size();
				else {
					int r = a.get(i).get(N - m - 1) + 1;
					System.out.println(r);
					out.println(r);
					return;
				}
	}
}
